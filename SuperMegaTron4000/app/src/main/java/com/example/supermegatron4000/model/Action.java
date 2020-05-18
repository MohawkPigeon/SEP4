package com.example.supermegatron4000.model;

public class Action {
    public int ActionID;
    public int command;

    public Action(int actionID, int command) {
        ActionID = actionID;
        this.command = command;
    }

    public int getActionID() {
        return ActionID;
    }

    public void setActionID(int actionID) {
        ActionID = actionID;
    }

    public int getCommand() {
        return command;
    }

    public void setCommand(int command) {
        this.command = command;
    }


}
