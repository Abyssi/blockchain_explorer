package Sketch.Model.Generic;

import Sketch.Model.Interfaces.Updatable;
import Sketch.Core.Vectors.Vector3D;

public class State implements Updatable {
    private Vector3D position;
    private Vector3D speed;
    private Vector3D acceleration;

    public State() {
        this(new Vector3D(), new Vector3D(), new Vector3D());
    }

    public State(Vector3D position, Vector3D speed, Vector3D acceleration) {
        this.position = position;
        this.speed = speed;
        this.acceleration = acceleration;
    }

    public Vector3D getPosition() {
        return position;
    }

    public Vector3D getSpeed() {
        return speed;
    }

    public Vector3D getAcceleration() {
        return acceleration;
    }

    @Override
    public void update() {
        this.speed.add(this.acceleration);
        this.position.add(this.speed);
    }
}
