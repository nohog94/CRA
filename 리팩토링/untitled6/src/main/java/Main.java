import java.util.ArrayList;
import java.util.List;

interface Command {
    public void execute();
    public void undo();
}

class TV {

    public void up() {
        System.out.println("채널올라갔어요");
    }

    public void down() {
        System.out.println("채널내려갔어요");
    }
}


class ChannelUp implements Command {

    private TV tv;

    public ChannelUp(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.up();
    }

    @Override
    public void undo() {
        tv.down();
    }
}

class ChannelDown implements Command {

    private TV tv;

    public ChannelDown(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.down();
    }

    @Override
    public void undo() {
        tv.up();
    }
}

class RemoteController {
    List<Command> history = new ArrayList<>();

    void runCommand(Command cmd) {
        cmd.execute();
        history.add(cmd);
    }

    void undoCommand() {
        int lastIndex = history.size() - 1;
        history.get(lastIndex).undo();
        history.remove(lastIndex);

    }
}

public class Main {
    public static void main(String[] args) {
        RemoteController rm = new RemoteController();
        TV tv = new TV();
        rm.runCommand(new ChannelDown(tv));
        rm.runCommand(new ChannelDown(tv));
        rm.runCommand(new ChannelUp(tv));

        for (int i=0; i<3; i++) {
            rm.undoCommand();
        }
    }
}