package assignment4;

public class MoodTester {
    public static void main(String[] args){
        PsychiatristObject psy = new PsychiatristObject();
        MoodyObject happy = new HappyObject();
        MoodyObject sad = new SadObject();
        psy.examine(happy);
        psy.observe(happy);
        psy.examine(sad);
        psy.observe(sad);


    }
}

abstract class MoodyObject{
    protected abstract String getMood();

    protected abstract void expressFeelings();

    public void queryMood(){
        String name = getClass().getSimpleName();

        if(name.equals("SadObject")) {
            System.out.println("I feel sad today!");
        }
        else
            System.out.println("I feel happy today!");
    }
}

class SadObject extends MoodyObject{
    protected String getMood(){
        return "sad";
    }

    public void expressFeelings(){
        System.out.println("'wah' 'boo hoo' 'weep' 'sob' 'weep'");
    }

    public String toString(){
        return "Subject cries a lot";
    }
}

class HappyObject extends MoodyObject{
    protected String getMood(){
        return "happy";
    }

    public void expressFeelings(){
        System.out.println("hehehe...hahahah...HAHAHAHAHA!!!");
    }

    public String toString(){
        return "Subject laughs a lot";
    }

}

class PsychiatristObject{
    public void examine(MoodyObject moodyObject){
        System.out.println("How are you feeling today?");
        moodyObject.queryMood();
    }

    public void observe(MoodyObject moodyObject){
        moodyObject.expressFeelings();
        System.out.println("Observation:" + moodyObject.toString());
    }
}
