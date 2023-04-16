import sys

from entities.Message import Message
from strategies.importExportUtils import exportToJson

if __name__ == "__main__":

    message = Message.parseMessage(sys.argv[1])
    if Message.Operation(message.operation).name == Message.Operation.EXPORT.name:
        exportToJson(message.scenario)
    elif Message.Operation(message.operation).name == Message.Operation.RUN.name:
        message.scenario.runSimulation()
