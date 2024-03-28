#Funcion allows user to customize their pizza option and view relevant information
def order_pizza():

    #Defines the ratio titles
    ratios = ["Cheese", "Sauce", "Toppings"]
    #Defines the ingredient ratios of the pizza types
    margherita = [50, 30, 20]
    vegetarian = [40, 35, 25]
    meat = [45, 30, 25]

    #Defines the price for pizza sizes Personal/Medium/Family
    price = [8, 12, 16]

    #Check to validate correct order entry
    valid_order = True

    #Prints instructions and input options for user
    print("Welcome to Slice Haven!")
    print("Here are the available options:")
    print("1. Margherita")
    print("2. Vegetarian")
    print("3. Meat Lovers")
    print("\nSize:")
    print("Personal")
    print("Medium")
    print("Family")
    
    #presents user with input for order
    pizza_type = input("Enter the type of pizza you want: ")
    size = input("Enter the size of pizza (Personal/Medium/Family): ")

    #Assigns the pizza type order ratios
    if pizza_type == "Margherita":
        order = margherita
    elif pizza_type == "Vegetarian":
        order = vegetarian
    elif pizza_type == "Meat Lovers":
        order = meat
    else:
        #Returns error comment if incorrect type entered
        print("Invalid Pizza Type Entered")
        #prevents for loop running if order invalid
        valid_order = False

    #Finds the price of the ordered pizza size
    if size == "Personal":
        order_price = price[0]
    elif size == "Medium":
        order_price = price[1]
    elif size == "Family":
        order_price = price[2]
    else:
        #Returns error comment if incorrect size entered
        print("Invalid Pizza Size Entered")
        #prevents for loop running if order invalid
        valid_order = False

    #Check if pizza type is valid
    if valid_order == True:
        #Prints start of order
        print("\nYour order summary:")
        print(f"Type: {pizza_type}, Size: {size}")

        #Prints pizza ingredient ratios for the order
        print("Ingredient Ratios:")
        for i in range(3):
            print(f"\t{ratios[i]}: {order[i]}%")

        #Prints the price of the pizza order
        print(f"Total Cost: ${order_price}")

        

#Runs the function to order pizza
order_pizza()
