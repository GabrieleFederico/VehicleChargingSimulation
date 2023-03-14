import sys

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
from strategies.utils import exportToJson


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
        self.ui.importPushButton.clicked.connect(self.importFromCSV)
        self.ui.runPushButton.clicked.connect(self.runSimulation)
        self.show()

    def addFrame(self):
        self.createNewVehicleWidget()

    def createNewVehicleWidget(self):
        widget = VehicleWidget()
        widget.setParent(self.ui.scrollAreaWidgetContents)
        self.widgets.append(widget)
        self.ui.verticalLayout.addWidget(widget)
        #self.ui.scrollArea.setWidget(self.ui.scrollAreaWidgetContents)

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

        exportToJson(vehicles)

        return

    def importFromJSON(self):
        #TODO: ask the user to select a csv file
        #TODO: parse the csv
        pass


if __name__ == "__main__":
    app = QApplication(sys.argv)

    window = MainWindow()
    window.show()

    sys.exit(app.exec())

