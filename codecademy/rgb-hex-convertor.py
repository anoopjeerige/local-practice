"""
RBG-HEX Converter
Program to covert the given RGB value to corresponding HEX value and vice-versa
"""

INVALID_MSG = "Invalid RGB/HEX value entered!"


def rgb_hex():
    red = int(raw_input("Enter red value: "))
    if red < 0 or red > 255:
        print INVALID_MSG
        return
    green = int(raw_input("Enter green value: "))
    if green < 0 or green > 255:
        print INVALID_MSG
        return
    blue = int(raw_input("Enter blue value: "))
    if blue < 0 or blue > 255:
        print INVALID_MSG
        return
    val = (red << 16) + (green << 8) + blue
    print "%s" % (hex(val).upper()[2:])

def hex_rgb():
    hex_val = raw_input("Enter hex value 6 digits: ")
    if len(hex_val) != 6:
        print INVALID_MSG
        return
    else:
        hex_val = int(hex_val, 16)
        two_hex_digits = 2 ** 8
        blue = hex_val % two_hex_digits
        hex_val = hex_val >> 8
        green = hex_val % two_hex_digits
        hex_val = hex_val >> 8
        red = hex_val % two_hex_digits
        print "%s,%s,%s" % (red, green, blue)

def convert():
    while True:
        option = raw_input("Enter 1 to convert RGB to HEX.\nEnter 2 to convert HEX to RGB. \n Enter X to Exit:")
        if option == "1":
            print "RGB to HEX..."
            rgb_hex()
        elif option == "2":
            print "HEX to RGB..."
            hex_rgb()
        elif option == "X":
            break
        else:
            print "Error"

convert()
