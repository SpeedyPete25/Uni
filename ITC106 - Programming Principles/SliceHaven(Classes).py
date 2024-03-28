class Pizza:
    def __init__(self, pizza_type, size):
        self.pizza_type = pizza_type
        self.size = size
        self.prices = {"Margherita": {"Personal": 8, "Medium": 12, "Family": 18},
                       "Vegetarian": {"Personal": 8, "Medium": 12, "Family": 18},
                       "Meat Lovers": {"Personal": 8, "Medium": 12, "Family": 18}}
        self.ingredients = {"Margherita": {"Cheese": 50, "Sauce": 30, "Toppings": 20},
                            "Vegetarian": {"Cheese": 40, "Sauce": 35, "Toppings": 25},
                            "Meat Lovers": {"Cheese": 45, "Sauce": 30, "Toppings": 25}}

    def calculate_cost(self):
        return self.prices[self.pizza_type][self.size]

    def get_ingredient_ratios(self):
        return self.ingredients[self.pizza_type]

def order_pizza():
    print("Welcome to our pizza shop!")
    print("Here are the available options:")
    print("1. Margherita")
    print("2. Vegetarian")
    print("3. Meat Lovers")
    pizza_type = input("Enter the type of pizza you want: ")
    size = input("Enter the size of pizza (Personal/Medium/Family): ")

    pizza = Pizza(pizza_type, size)
    total_cost = pizza.calculate_cost()
    ingredient_ratios = pizza.get_ingredient_ratios()

    print("\nYour order summary:")
    print(f"Type: {pizza.pizza_type}, Size: {pizza.size}")
    print("Ingredient Ratios:")
    for ingredient, ratio in ingredient_ratios.items():
        print(f"{ingredient}: {ratio}")
    print(f"Total Cost: ${total_cost}")

order_pizza()