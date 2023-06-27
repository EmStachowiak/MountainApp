package com.example.mountainapp;

public class MountainPeak {


        private static int id;
        private String mountainPeak;
        private int height;
        private int verticalGain;
        private float distance;
        private int idList = 0;


        public MountainPeak(String mountainPeak, int height, int verticalGain, float distance) {
            this.id++;
            this.mountainPeak = mountainPeak;
            this.height = height;
            this.verticalGain = verticalGain;
            this.distance = distance;
            idList = id;
        }

        public int getId() {
            return id;
        }


        public String getMountainPeak() {
            return mountainPeak;
        }



        public int getHeight() {
            return height;
        }



        public int getVerticalGain() {
            return verticalGain;
        }


        public float getDistance() {
            return distance;
        }




        @Override
        public String toString() {
            return "com.example.mountainapp.MainActivity.MountainPeak[" +
                    "id=" + id +
                    ", mountainPeak='" + mountainPeak + '\'' +
                    ", height=" + height +
                    ", verticalGain=" + verticalGain +
                    ", distance=" + distance +
                    ']';
        }



}
