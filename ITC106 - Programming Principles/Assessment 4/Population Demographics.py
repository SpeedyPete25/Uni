import matplotlib.pyplot as plt
import operator

#Loads population data from given file
def load_data(file_name):
    
    data = []
    try:
        with open(file_name, 'r') as file:
            headers = file.readline().strip().split('|')
            for line in file:
                values = line.strip().split('|')
                record = {headers[i]: values[i] for i in range(len(headers))}
                data.append(record)
    except FileNotFoundError:
        print("Error: File not found.")
        return None
    return data

#Displays demographic details for selected region
def display_region_demographics(data, region):
    
    region_data = next((item for item in data if item['Region'] == region), None)
    if region_data:
        for key, value in region_data.items():
            print(f"{key}: {value}")
    else:
        print("Error: Region not found.")

#Plots the distribution of age groups
def plot_age_group_distribution(data):
    
    children = sum(int(item['Children (0-14 years)']) for item in data)
    adults = sum(int(item['Adults (15-64 years)']) for item in data)
    seniors = sum(int(item['Seniors (65+ years)']) for item in data)

    labels = 'Children (0-14 years)', 'Adults (15-64 years)', 'Seniors (65+ years)'
    sizes = [children, adults, seniors]

    plt.figure(figsize=(8, 8))
    plt.pie(sizes, labels=labels, autopct='%1.1f%%', startangle=140)
    plt.title('Age Group Distribution')
    plt.show()

#Plots bar chart comparing urban and rural populations for a selected region
def plot_urban_vs_rural(data, region):
    
    region_data = next((item for item in data if item['Region'] == region), None)
    if region_data:
        urban_population = int(region_data['Urban Population'])
        rural_population = int(region_data['Rural Population'])

        plt.figure(figsize=(8, 6))
        plt.bar(['Urban', 'Rural'], [urban_population, rural_population], color=['blue', 'green'])
        plt.title(f'Urban vs. Rural Population in {region}')
        plt.ylabel('Population')
        plt.show()
    else:
        print("Error: Region not found.")

#Plots a bar chart representing the top 5 populated regions
def plot_top_5_populated_regions(data):
    
    sorted_data = sorted(data, key=lambda x: int(x['Total Population']), reverse=True)[:5]
    regions = [item['Region'] for item in sorted_data]
    populations = [int(item['Total Population']) for item in sorted_data]

    plt.figure(figsize=(10, 6))
    plt.bar(regions, populations, color='orange')
    plt.title('Top 5 Populated Regions')
    plt.xlabel('Regions')
    plt.ylabel('Population')
    plt.show()

#Main function
#Prompts the user for the dataset file and presents a menu for different analysis options
def main():
    
    #gets file name from user and loads it
    file_name = input("Enter the dataset file name: ")
    data = load_data(file_name)

    if not data:
        return

    while True:
        print("\nMain Menu:")
        print("1. Region Demographics")
        print("2. Age Group Distribution")
        print("3. Urban vs. Rural Population Chart")
        print("4. Top 5 Populated Regions Chart")
        print("5. Exit the program")

        choice = input("Choose an option: ")

        if choice == '1':
            region = input("Enter the region name: ")
            display_region_demographics(data, region)
        elif choice == '2':
            plot_age_group_distribution(data)
        elif choice == '3':
            region = input("Enter the region name: ")
            plot_urban_vs_rural(data, region)
        elif choice == '4':
            plot_top_5_populated_regions(data)
        elif choice == '5':
            print("Exiting the program.")
            break
        else:
            print("Invalid option. Please try again.")

#Entry point
if __name__ == "__main__":
    main()
