import random
def passGen():
    """
    Generates a password for the user
    Requires: NONE
    Ensures: str with the new password
    """
    num=str(random.randint(1000,9999))
    all,password=[],""
    for char in num:
        all.append(char)
        all.append(random.choice("[!@#$%^:{&*(),.?}|<>]"))
        all.append(random.choice("uSNcciihCakcjRiQrREzhiEfdYcAuGGuIYwIvwkRGhQLicPzDywG"))
    random.shuffle(all)
    for thing in all:
        password+=thing
    return password

def passStrength(passw):
    """
    Gives the user the strenght of their password

    Requires: passw str representing the string of the user
    Ensures: str with the stregth level
    """
    specialChars = "[!@#$%^:{&*(),.?}|<>]"
    upperCount, numberCount,specialCount, total = 0,0,0,0

    if len(passw) < 8:
        print("The password hsa less than 8 characters.")
        return "weak"
    for char in passw:
        if char.isupper():
            upperCount += 1
        elif char.isdigit():
            numberCount += 1
        elif char in specialChars:
            specialCount += 1
        elif char not in specialChars and not char.isupper() and not char.isdigit() and not char.islower():
            print(f"ERROR: YOUR PASSWORD COINTAINS AN ILLEGAL CHARACTER! WHICH IS: {char}")
            return "error"
    
    if upperCount == 0 or numberCount == 0 or specialCount == 0:
        print(f"""The total of upper Words is:{upperCount}
                The total of special Words is: {specialCount}
                The total of numbers is: {numberCount}""")
        return "error"
    elif len(passw) >= 8 and len(passw) < 12 and specialCount == 1 and numberCount == 1:
        return "medium"
    elif len(passw) >= 12 and specialCount > 1 or numberCount > 1:
        return "strong"
    else: #for passwords that are long but dont have many special chars or numbers
        return "medium"
    