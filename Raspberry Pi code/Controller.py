import requests
import RPi.GPIO as GPIO
import time


# Set up GPIO

GPIO.setmode(GPIO.BCM)

# Setup for pins
GPIO_PIN_1 = 21
GPIO.setup(GPIO_PIN_1, GPIO.OUT)

GPIO_PIN_2 = 20
GPIO.setup(GPIO_PIN_2, GPIO.OUT)

GPIO_PIN_3 = 26
GPIO.setup(GPIO_PIN_3, GPIO.OUT)

GPIO_PIN_4 = 16
GPIO.setup(GPIO_PIN_4, GPIO.OUT)

GPIO_PIN_5 = 13
GPIO.setup(GPIO_PIN_5, GPIO.OUT)

GPIO_PIN_6 = 12
GPIO.setup(GPIO_PIN_6, GPIO.OUT)


url = "http://localhost:3001/pumps"
# API endpoints
One_url = url + "/1"
Two_url = url + "/2"
Three_url = url + "/3"
Four_url = url + "/4"
Five_url = url + "/5"
Six_url =  url + "/6"

# Function to get status from the API
def get_api_status1():
    try:
        response = requests.get(One_url)
        response.raise_for_status()
        return response.json()
    except requests.exceptions.RequestException as e:
        print(f"Error: {e}")
        return None

def get_api_status2():
    try:
        response = requests.get(Two_url)
        response.raise_for_status()
        return response.json()
    except requests.exceptions.RequestException as e:
        print(f"Error: {e}")
        return None

def get_api_status3():
    try:
        response = requests.get(Three_url)
        response.raise_for_status()
        return response.json()
    except requests.exceptions.RequestException as e:
        print(f"Error: {e}")
        return None

def get_api_status4():
    try:
        response = requests.get(Four_url)
        response.raise_for_status()
        return response.json()
    except requests.exceptions.RequestException as e:
        print(f"Error: {e}")
        return None

def get_api_status5():
    try:
        response = requests.get(Five_url)
        response.raise_for_status()
        return response.json()
    except requests.exceptions.RequestException as e:
        print(f"Error: {e}")
        return None

def get_api_status6():
    try:
        response = requests.get(Six_url)
        response.raise_for_status()
        return response.json()
    except requests.exceptions.RequestException as e:
        print(f"Error: {e}")
        return None

# Function to control GPIO based on API status
def control_gpio1(One):
    if One is not None:
        if One["status"] == "Off":
            GPIO.output(GPIO_PIN_1, GPIO.HIGH)
        elif One["status"] == "On":
            GPIO.output(GPIO_PIN_1, GPIO.LOW)
        else:
            GPIO.output(GPIO_PIN_1, GPIO.HIGH)
            print("Invalid status")
    else:
        GPIO.output(GPIO_PIN_1, GPIO.HIGH)
        print("Failed")

def control_gpio2(Two):
    if Two is not None:
        try:
            if Two["status"] == "Off":
                GPIO.output(GPIO_PIN_2, GPIO.HIGH)
            elif Two["status"] == "On":
                GPIO.output(GPIO_PIN_2, GPIO.LOW)
            else:
                GPIO.output(GPIO_PIN_1, GPIO.HIGH)
                print("Invalid status")
        except KeyError:
            print("Failed")
    else:
        GPIO.output(GPIO_PIN_2, GPIO.HIGH)
        print("Failed")

def control_gpio3(Three):
    if Three is not None:
        try:
            if Three["status"] == "Off":
                GPIO.output(GPIO_PIN_3, GPIO.HIGH)
            elif Three["status"] == "On":
                GPIO.output(GPIO_PIN_3, GPIO.LOW)
            else:
                print("Invalid status")
        except KeyError:
            print("Failed")
        GPIO.output(GPIO_PIN_3, GPIO.HIGH)



def control_gpio4(Four):
    if Four is not None:
        try:
            if Four["status"] == "Off":
                GPIO.output(GPIO_PIN_4, GPIO.HIGH)
            elif Four["status"] == "On":
                GPIO.output(GPIO_PIN_4, GPIO.LOW)
            else:
                print("Invalid status")
        except KeyError:
            print("Failed")
    else:
        print("Failed")
        GPIO.output(GPIO_PIN_4, GPIO.HIGH)


def control_gpio5(Five):
    if Five is not None:
        try:
            if Five["status"] == "Off":
                GPIO.output(GPIO_PIN_5, GPIO.HIGH)
            elif Five["status"] == "On":
                GPIO.output(GPIO_PIN_5, GPIO.LOW)
            else:
                print("Invalid status")
        except KeyError:
            print("Failed")
    else:
        print("Failed")
        GPIO.output(GPIO_PIN_5, GPIO.HIGH)

def control_gpio6(Six):
    if Six is not None:
        try:
            if Six["status"] == "Off":
                GPIO.output(GPIO_PIN_6, GPIO.HIGH)
            elif Six["status"] == "On":
                GPIO.output(GPIO_PIN_6, GPIO.LOW)
            else:
                print("Invalid status")
        except KeyError:
            print("Failed")
    else:
        print("Failed")
        GPIO.output(GPIO_PIN_6, GPIO.HIGH)


# Main loop
try:

    while True:
        api_status = get_api_status1()  # Get API
        control_gpio1(api_status)
        api_status2 = get_api_status2()  # Get API
        control_gpio2(api_status2)
        api_status3 = get_api_status3()  # Get API
        control_gpio3(api_status3)
        api_status4 = get_api_status4()  # Get API
        control_gpio4(api_status4)
        api_status5 = get_api_status5()  # Get API
        control_gpio5(api_status5)
        api_status6 = get_api_status6()  # Get API
        control_gpio6(api_status6)





except KeyboardInterrupt:
    pass
finally:
    GPIO.cleanup()  # Clean up GPIO on program exit


