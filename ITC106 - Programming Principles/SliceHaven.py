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
    pizza_type = input("Enter the type of pizza you want: ")
    size = input("Enter the size of pizza (Personal/Medium/Family): ")

    #Prints start of order
    print("\nYour order summary:")
    print(f"Type: {pizza_type}, Size: {size}")

    #Prints each ingredient ratio for selected pizza type
    print("Ingredient Ratios:")
    for i in range(3):
        if pizza_type == "Margherita":
            print(f"\t{ratios[i]}: {margherita[i]}%")
        elif pizza_type == "Vegetarian":
            print(f"\t{ratios[i]}: {vegetarian[i]}%")
        elif pizza_type == "Meat Lovers":
            print(f"\t{ratios[i]}: {meat[i]}%")
        else:
            #Returns error comment if incorrect type entered
            print("Invalid Pizza Type Entered")

    #Prints the cost of the pizza based on size selected
    if size == "Personal":
        print(f"Total Cost: ${price[0]}")
    elif size == "Medium":
        print(f"Total Cost: ${price[1]}")
    elif size == "Family":
        print(f"Total Cost: ${price[2]}")
    else:
        #Returns error comment if incorrect size entered
        print("Invalid Pizza Size Entered")

#Runs the function to order pizza
order_pizza()
