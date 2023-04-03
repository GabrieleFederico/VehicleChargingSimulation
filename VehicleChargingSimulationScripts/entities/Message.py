from enum import Enum


class Message:
    class Operation(Enum):
        RUN = 0
        EXPORT = 1
        IMPORT = 2

    def __init__(self):
        self.version = 1

    def parseScenario(self, string):
        pass
