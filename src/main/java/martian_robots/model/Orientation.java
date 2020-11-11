package martian_robots.model;

public enum Orientation {
    N(){
        public Orientation turnLeft() {
            return W;
        }

        public Orientation turnRight() {
            return E;
        }
    },

    S(){
        public Orientation turnLeft() {
            return E;
        }

        public Orientation turnRight() {
            return W;
        }
    },

    E(){
        public Orientation turnLeft() {
            return N;
        }

        public Orientation turnRight() {
            return S;
        }
    },

    W(){
        public Orientation turnLeft() {
            return S;
        }

        public Orientation turnRight() {
            return N;
        }
    };

    public abstract Orientation turnLeft();
    public abstract Orientation turnRight();
}
