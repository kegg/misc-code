import pygame
import sys

# Initialize Pygame
pygame.init()

# Constants
WIDTH, HEIGHT = 800, 600
BLOCK_SIZE = 50
PROJECTILE_SIZE = 10
FPS = 60

# Colors
WHITE = (255, 255, 255)
BLUE = (0, 0, 255)
RED = (255, 0, 0)

# Create the window
screen = pygame.display.set_mode((WIDTH, HEIGHT))
pygame.display.set_caption("Move the Block and Fire Projectiles")

# Initial block position
block_x, block_y = WIDTH // 2 - BLOCK_SIZE // 2, HEIGHT // 2 - BLOCK_SIZE // 2

# Initial projectile position and state
projectile_x, projectile_y = 0, 0
projectile_active = False

# Set up the clock
clock = pygame.time.Clock()

# Main game loop
while True:
    # Handle events
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            pygame.quit()
            sys.exit()
        elif event.type == pygame.KEYDOWN:
            if event.key == pygame.K_SPACE and not projectile_active:
                # Fire a projectile if the spacebar is pressed and no projectile is currently active
                projectile_x, projectile_y = block_x + BLOCK_SIZE // 2 - PROJECTILE_SIZE // 2, block_y
                projectile_active = True

    # Get the state of all keys
    keys = pygame.key.get_pressed()

    # Update block position based on keys
    if keys[pygame.K_LEFT] and block_x > 0:
        block_x -= 5
    if keys[pygame.K_RIGHT] and block_x < WIDTH - BLOCK_SIZE:
        block_x += 5
    if keys[pygame.K_UP] and block_y > 0:
        block_y -= 5
    if keys[pygame.K_DOWN] and block_y < HEIGHT - BLOCK_SIZE:
        block_y += 5

    # Update projectile position
    if projectile_active:
        projectile_y -= 7
        # Check if the projectile is out of bounds
        if projectile_y < 0:
            projectile_active = False

    # Fill the screen with white
    screen.fill(WHITE)

    # Draw the block
    pygame.draw.rect(screen, BLUE, (block_x, block_y, BLOCK_SIZE, BLOCK_SIZE))

    # Draw the projectile if active
    if projectile_active:
        pygame.draw.rect(screen, RED, (projectile_x, projectile_y, PROJECTILE_SIZE, PROJECTILE_SIZE))

    # Update the display
    pygame.display.flip()

    # Cap the frame rate
    clock.tick(FPS)
