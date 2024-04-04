package character.physics;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;

public class Gravity {
    private static final double GRAVITY = 500;
    private static final double JUMP_VELOCITY = -300;
    private double velocity = 0;
    private boolean jumping = false;

    public void applyGravity(Scene scene, ImageView imageViewEnemy) {
        // Laisser le personnage sauter avec la touche espace
        scene.setOnKeyPressed((event) -> {
            if (event.getCode() == KeyCode.SPACE && !jumping) {
                velocity = JUMP_VELOCITY;
                jumping = true;
            }
        });

        new AnimationTimer() {
            private long lastUpdateTime = 0;
            private int test = 0;

            @Override
            public void handle(long now) {
                if (lastUpdateTime == 0) {
                    lastUpdateTime = now;
                    return;
                }

                // Calcul le temps entre le frame actuel et le frame précédent
                double deltaTime = (now - lastUpdateTime) / 1e9;

                // Calcul de la nouvelle vitesse et la nouvelle position du personnage
                velocity += GRAVITY * deltaTime;
                double newY = imageViewEnemy.getY() + velocity * deltaTime;

                // Regarder si le personnage est au sol (Y = 315)
                if (newY > 315) {
                    newY = 315;

                }

                if (jumping){
                    test++;
                }
                if (test == 20){
                    jumping = false;
                    test = 0;
                }


                // Met à jour la position du personnage
                imageViewEnemy.setY(newY);
                lastUpdateTime = now;
            }
        }.start();
    }
}
