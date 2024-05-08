import turtle

#----constants--->
#visual values
AXIS_COLOR = "black"
GRID_COLOR = "light gray"
ORIGIN_COLOR = "red"
LABEL_COLOR = "teal"
FONT_SIZE = 12
OUTPUT_SIZE = 36

#drawing parameter prompts
GRID_WIDTH = int(turtle.numinput("Grid Width","Enter Grid Width (600-2000): ", default=1000, minval=600, maxval=2000))
GRID_HEIGHT = int(turtle.numinput("Grid Height","Enter Grid Height (600-1000): ", default=800, minval=600, maxval=1000))
STEP = int(turtle.numinput("Grid Step Size","Enter Grid Step size: ", default=100, minval=50, maxval=200))

#assigns location for clicked coordinates text output
OUTPUT_X = -(GRID_WIDTH/2)
OUTPUT_Y = (GRID_HEIGHT/2) + 20
#<---constants----

#function to draw grid tick lines
def draw_grid():
    #primes grid drawing
    turtle.pencolor(GRID_COLOR)
    
    #draws vertical tick lines
    turtle.goto(int(- STEP * ((GRID_WIDTH // 2) // STEP)), -GRID_HEIGHT // 2)
    for i in range(((GRID_WIDTH // 2) // STEP) * 2 + 1):
        turtle.setheading(90)
        turtle.pendown()
        turtle.forward(GRID_HEIGHT)
        turtle.penup()
        turtle.backward(GRID_HEIGHT)
        turtle.setheading(0)
        turtle.forward(STEP)

    #draws horizontal tick lines
    turtle.goto(-GRID_WIDTH // 2, int(- STEP * ((GRID_HEIGHT // 2) // STEP)))
    for i in range(((GRID_HEIGHT // 2) // STEP) * 2 + 1):
        turtle.setheading(0)
        turtle.pendown()
        turtle.forward(GRID_WIDTH)
        turtle.penup()
        turtle.backward(GRID_WIDTH)
        turtle.setheading(90)
        turtle.forward(STEP)

#function to draw axis lines
def draw_axis():
    #sets axis colour
    turtle.pencolor(AXIS_COLOR)
    
    #draws y axis
    turtle.goto(0, -GRID_HEIGHT // 2)
    turtle.pendown()
    turtle.goto(0, GRID_HEIGHT // 2)
    turtle.penup()
    
    #draws x axis
    turtle.goto(-GRID_WIDTH // 2, 0)
    turtle.pendown()
    turtle.goto(GRID_WIDTH // 2, 0)
    turtle.penup()

#function to draw origin point
def draw_origin():
    turtle.goto(0, 0)
    turtle.dot(ORIGIN_COLOR)

#function to label axis markers
def label_axis():
    #sets label colour
    turtle.pencolor(LABEL_COLOR)
    
    #writes y axis grid ticks
    turtle.setheading(90)
    yCoord = int(- STEP * ((GRID_HEIGHT // 2) // STEP))
    turtle.goto(-(GRID_WIDTH//2) - 50, yCoord - 10)
    for i in range(((GRID_HEIGHT // 2) // STEP) * 2 + 1):
        turtle.write(f"{yCoord}", align="center", font=("Arial", FONT_SIZE, "normal"))
        yCoord += STEP
        turtle.forward(STEP)

    #writes x axis grid ticks
    turtle.setheading(0)
    xCoord = int(- STEP * ((GRID_WIDTH // 2) // STEP))
    turtle.goto(xCoord, -(GRID_HEIGHT/2) - 60)
    for i in range(((GRID_WIDTH // 2) // STEP) * 2 + 1):
        turtle.write(f"{xCoord}", align="center", font=("Arial", FONT_SIZE, "normal"))
        xCoord += STEP
        turtle.forward(STEP)

#function to display coordinates
def display_coordinates(x, y):
    
    #check to see if click is within grid
    if x >= -(GRID_WIDTH/2) and x <= (GRID_WIDTH/2) and y >= -(GRID_HEIGHT/2) and y <= (GRID_HEIGHT/2):
        #removes previous coordinates
        turtle.undo()
        turtle.clearstamps(None)

        #places stamp at clicked coordinate
        turtle.penup()
        turtle.goto(x,y)
        turtle.pendown()
        turtle.stamp()

        #writes clicked coordinate
        turtle.penup()
        turtle.goto(OUTPUT_X, OUTPUT_Y)
        turtle.pendown()
        turtle.write(f"Clicked Coordinate: ({int(x)},{int(y)})", align="left", font=("Arial", OUTPUT_SIZE, "normal"))
        
#main function
def main():
    
    #sets up the plot
    turtle.setup(GRID_WIDTH + 200, GRID_HEIGHT + 200)
    turtle.tracer(0)
    turtle.hideturtle()
    turtle.title("Cartesian Coordinate Drawing")
    turtle.penup()
    
    #draws the plot
    draw_grid()
    draw_axis()
    draw_origin()
    label_axis()

    #primes the clicked coordinates output
    turtle.pendown()
    turtle.setheading(90)
    turtle.penup()
    display_coordinates(0,0)
    
    #event listener for mouse click to display coordinates
    turtle.onscreenclick(display_coordinates)
    
    #stop execution
    turtle.done()

#entry point
if __name__ == "__main__":
    main()
