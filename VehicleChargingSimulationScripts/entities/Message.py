from enum import Enum

from entities.Scenario import Scenario


class Message:
    class Operation(Enum):
        RUN = 0
        EXPORT = 1
        IMPORT = 2

    def __init__(self):
        self.scenario = None
        self.version = 1
        self.operation = -1

    @classmethod
    def parseMessage(cls, string):
        message = Message()

        splitString = string.split(":")
        versionOperation = splitString[0].split("operation=")
        if versionOperation[1] == "RUN":
            message.operation = 0
        elif versionOperation[1] == "EXPORT":
            message.operation = 1
        elif versionOperation[1] == "IMPORT":
            message.operation = 2

        message.scenario = Scenario.parseScenario(splitString[1])

        return message
