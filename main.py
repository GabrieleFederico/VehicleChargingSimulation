import sys
import json
from pydoc import text

from PySide6 import QtCore
from PySide6.QtCore import QSize, Qt
from PySide6.QtWidgets import QFrame, QWidget
from PySide6.QtWidgets import QApplication, QMainWindow
from GUIs.QTDesigner.MainWindow import Ui_MainWindow
from GUIs.QTDesigner.VehicleWidget import Ui_vehicleWidget
from entities.Scenario import Scenario
from entities.Station import Station
from entities.Vehicle import Vehicle
from strategies.EDF import EDF
from strategies.FCFS import FCFS
from strategies.RoundRobin import RoundRobin


class VehicleWidget(QWidget):
    def __init__(self):
        super(VehicleWidget, self).__init__()
        self.ui = Ui_vehicleWidget()
        self.ui.setupUi(self)


class MainWindow(QMainWindow):
    def __init__(self):
        super(MainWindow, self).__init__()
        self.widgets = []
        self.ui = Ui_MainWindow()
        self.ui.setupUi(self)
        self.ui.addVehicleButton.clicked.connect(self.addFrame)
        self.ui.exportPushButton.clicked.connect(self.exportToJson)
        self.ui.runPushButton.clicked.connect(self.runSimulation)
        self.show()

    def addFrame(self):
        self.createNewVehicleWidget()

    def createNewVehicleWidget(self):
        widget = VehicleWidget()
        widget.setParent(self.ui.scrollAreaWidgetContents)
        self.widgets.append(widget)
        self.ui.verticalLayout.addWidget(widget)
        self.ui.scrollArea.setWidget(self.ui.scrollAreaWidgetContents)

    def runSimulation(self):
        scenario = Scenario()
        if self.ui.strategyComboBox.currentText() == "FCFS":
            scenario.addStation("S1", Station(FCFS()))
        elif self.ui.strategyComboBox.currentText() == "EDF":
            scenario.addStation("S1", Station(EDF()))
        elif self.ui.strategyComboBox.currentText() == "RR":
            scenario.addStation("S1", Station(RoundRobin()))

        for widget in self.widgets:
            vehicle = Vehicle(name=widget.ui.nameTextEdit.toPlainText(),
                              arrival=int(widget.ui.arrivalTextEdit.toPlainText()),
                              departure=int(widget.ui.departureTextEdit.toPlainText()),
                              desiredCharge=float(widget.ui.desiredChargeTextEdit.toPlainText()))
            vehicle.getBattery().capacity = float(widget.ui.capacityTextEdit.toPlainText())
            vehicle.getBattery().chargePower = float(widget.ui.chargePowerTextEdit.toPlainText())
            vehicle.getBattery().stateOfCharge = float(widget.ui.socTextEdit.toPlainText())

            scenario.getStations()["S1"].addVehicle(vehicle)
            
        scenario.runSimulation()
        return

    def exportToJson(self):
        vehicles = []
        for widget in self.widgets:
            vehicle = Vehicle(name=widget.ui.nameTextEdit.toPlainText(),
                              arrival=int(widget.ui.arrivalTextEdit.toPlainText()),
                              departure=int(widget.ui.departureTextEdit.toPlainText()),
                              desiredCharge=float(widget.ui.desiredChargeTextEdit.toPlainText()))
            vehicle.getBattery().capacity = float(widget.ui.capacityTextEdit.toPlainText())
            vehicle.getBattery().chargePower = float(widget.ui.chargePowerTextEdit.toPlainText())
            vehicle.getBattery().stateOfCharge = float(widget.ui.socTextEdit.toPlainText())
            vehicles.append(vehicle)

        vehiclesList = []
        for vehicle in vehicles:
            vehiclesList.append(vehicle.toDict())
        jsonObject = json.dumps(vehiclesList, indent=4, )
        with open("JSONFiles/vehicles.json", "w") as out:
            out.write(jsonObject)

        return

if __name__ == "__main__":
    app = QApplication(sys.argv)

    window = MainWindow()
    window.show()

    sys.exit(app.exec())

# if __name__ == '__main__':
#    app = QApplication(sys.argv)
#    ex = MainWindow()
#    exportToCsvScenarioResult()
#    sys.exit(app.exec_())
