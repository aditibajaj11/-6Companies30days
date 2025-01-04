class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int horizontaldist=0;
        int verticaldist=0;

        if(xCenter<x1){
            horizontaldist=x1-xCenter;
        }
        else if(xCenter>x2){
            horizontaldist=xCenter-x2;
        }

        if(yCenter<y1){
            verticaldist=y1-yCenter;
        }
        else if(yCenter>y2){
            verticaldist=yCenter-y2;
        }

        return (horizontaldist * horizontaldist  + verticaldist * verticaldist) <= radius*radius;        
    }
}