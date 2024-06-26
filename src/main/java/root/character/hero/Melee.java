package character.hero;
import character.Enemy;
import character.Hero;
import character.physics.Background;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Melee extends Hero {
    // -------------- Constructor --------------
    public Melee() {
        this.image = new Image("file:src/main/resources/kaido.png");
        this.imageView = new ImageView(image);
        this.ratio = 0.85; // 0.85
        this.healthStatus = 100;
        this.imageView.setX(Background.WIDTH);
        this.imageView.setY(Math.random() * (Background.HEIGHT - imageView.getFitHeight()));
    }

    // -------------- Interaction --------------
    @Override
    public void interaction(Enemy enemy) {
        enemy.setHealthStatus(0);
    }

    // -------------- Position --------------
    @Override
    public void updatePosition(int nbOfCoins, double dt) {
        imageView.setX(imageView.getX() - ((vx / frameRate) + (nbOfCoins * 10) * dt));
    }
}
