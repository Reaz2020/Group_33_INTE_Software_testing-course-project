public class Tile {
    private boolean fire ;
    private boolean hills;
    private boolean jangle;
    private Position coordinate;
    private boolean enemy;
    private boolean empty;
    private boolean level;
    private boolean life;

    public Tile(Position coordinate, boolean fire, boolean hills, boolean jangle, boolean enemy, boolean empty, boolean level, boolean life) {
        this.fire=fire;
        this.hills=hills;
        this.jangle=jangle;
        this.enemy=enemy;
        this.empty=empty;
        this.level=level;
        this.life=life;
        this.coordinate=coordinate;
        if(checkIfOneElementIsTrueOnOneTile()==false)

            throw new IllegalArgumentException("Cant place two item in same tiles");
    }
    public Tile(Position position)
    {
        this(position,false,false,false,false,true,false,false);
    }

    protected boolean checkIfOneElementIsTrueOnOneTile() {//made protected
        if(fire && !hills && !jangle && !enemy && !empty && !level && !life) return true;
        if(!fire && hills && !jangle && !enemy && !empty && !level && !life) return true;
        if(!fire && !hills && jangle && !enemy && !empty && !level && !life) return true;
        if(!fire && !hills && !jangle && enemy && !empty && !level && !life) return true;
        if(!fire && !hills && !jangle && !enemy && empty && !level && !life) return true;
        if(!fire && !hills && !jangle && !enemy && !empty && level && !life) return true;
        if(!fire && !hills && !jangle && !enemy && !empty && !level && life) return true;
        return false;
    }

    protected boolean isFire() {
        return fire;
    }//made protected underneath

    protected boolean isHills() {
        return hills;
    }

    protected boolean isJangle() {
        return jangle;
    }

    public Position getCoordinate() {
        return coordinate;
    }

    protected boolean isEnemy() {
        return enemy;
    }

    protected boolean isEmpty() {
        return empty;
    }

    protected boolean isLevel() {
        return level;
    }

    protected boolean isLife() {
        return life;
    }
}