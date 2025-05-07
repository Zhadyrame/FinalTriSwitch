package io.github.finaltriswitch.logic;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import io.github.finaltriswitch.characters.MissJ;
import io.github.finaltriswitch.characters.MissK;
import io.github.finaltriswitch.characters.MrB;
import io.github.finaltriswitch.characters.Character;

public class GameLogic {
    // Объявляем персонажей игры
    private MissJ missJ;
    private MissK missK;
    private MrB mrB;

    // Активный персонаж, которым сейчас управляем
    private Character activeCharacter;

    // Флаги — достиг ли персонаж цели
    private boolean missJReachedGoal;
    private boolean missKReachedGoal;
    private boolean mrBReachedGoal;

    public GameLogic() {
        // Создаем персонажей с начальными координатами
        missJ = new MissJ(400, 600);
        missK = new MissK(0, 150);
        mrB = new MrB(700, 450);

        // По умолчанию активен MissJ
        activeCharacter = missJ;

        // Сброс флагов достижения цели
        resetGoals();
    }

    // Переключение активного персонажа
    public void switchToMissJ() { activeCharacter = missJ; }
    public void switchToMissK() { activeCharacter = missK; }
    public void switchToMrB() { activeCharacter = mrB; }

    // Геттеры для активного персонажа и всех героев
    public Character getActiveCharacter() { return activeCharacter; }
    public MissJ getMissJ() { return missJ; }
    public MissK getMissK() { return missK; }
    public MrB getMrB() { return mrB; }

    // Обновление логики каждого персонажа
    public void update(float delta) {
        missJ.act(delta);
        missK.act(delta);
        mrB.act(delta);
    }

    // Отрисовка персонажей
    public void render(SpriteBatch batch) {
        missJ.draw(batch, 1);
        missK.draw(batch, 1);
        mrB.draw(batch, 1);
    }

    // Установка флага «персонаж достиг цели»
    public void setReachedGoal(Character character) {
        if (character instanceof MissJ) missJReachedGoal = true;
        else if (character instanceof MissK) missKReachedGoal = true;
        else if (character instanceof MrB) mrBReachedGoal = true;
    }

    // Проверка: все ли персонажи достигли цели
    public boolean allReachedGoal() {
        return missJReachedGoal && missKReachedGoal && mrBReachedGoal;
    }

    // Сброс флагов целей
    public void resetGoals() {
        missJReachedGoal = false;
        missKReachedGoal = false;
        mrBReachedGoal = false;
    }

    // Освобождение ресурсов (текстур)
    public void dispose() {
        missJ.dispose();
        missK.dispose();
        mrB.dispose();
    }
}
