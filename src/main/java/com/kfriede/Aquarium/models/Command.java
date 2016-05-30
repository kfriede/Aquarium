package com.kfriede.Aquarium.models;

import java.util.List;

public class Command {
	private final String commandName;
	private final String command;
	private final List<Parameter> parameters;
	private final String tooltip;
	
	public Command (String commandName, String command, List<Parameter> parameters, String tooltip) {
		this.commandName = commandName;
		this.command = command;
		this.parameters = parameters;
		this.tooltip = tooltip;
	}

	public String getCommandName() {
		return commandName;
	}

	public String getCommand() {
		return command;
	}

	public List<Parameter> getParameters() {
		return parameters;
	}

	public String getTooltip() {
		return tooltip;
	}
	
	@Override
    public String toString() {
        return commandName;
    }

	
	
}