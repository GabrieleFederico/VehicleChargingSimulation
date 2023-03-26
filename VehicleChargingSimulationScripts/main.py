import sys

from tkinter import *
from tkinter import Tk
from tkinter import filedialog

from PySide6.QtWidgets import QWidget, QApplication, QMainWindow
from GUIs.QTDesigner.MainWindow import Ui_MainWindow
from GUIs.QTDesigner.VehicleWidget import Ui_vehicleWidget
from entities.Scenario import Scenario
from entities.Station import Station
from entities.Vehicle import Vehicle
from strategies.EDF import EDF
from strategies.FCFS import FCFS
from strategies.RoundRobin import RoundRobin
from strategies.utils import exportToJson, importFromJson


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
        self.ui.importPushButton.clicked.connect(self.importFromJSON)
        self.ui.runPushButton.clicked.connect(self.runSimulation)
        self.show()

    def addFrame(self):
        self.createNewVehicleWidget()

    def createNewVehicleWidget(self):
        widget = VehicleWidget()
        widget.setParent(self.ui.scrollAreaWidgetContents)
        self.widgets.append(widget)
        self.ui.verticalLayout.addWidget(widget)
        # self.ui.scrollArea.setWidget(self.ui.scrollAreaWidgetContents)

    def runSimulation(self):
        self.extractScenario().runSimulation()
        return

    def exportToJson(self):
        exportToJson(self.extractScenario())
        return

    def importFromJSON(self):
        self.open_file()
        return

    def open_file(self):
        Tk().withdraw()
        filepath = filedialog.askopenfilename(title="Open a json File",
                                              filetypes=(("json files", "*.json"), ("all files", "*.*")))
        file = open(filepath, 'r')
        print(file.read())
        importFromJson(file)
        file.close()

    def extractScenario(self):
        scenario = Scenario("Scenario one")
        if self.ui.strategyComboBox.currentText() == "FCFS":
            scenario.addStation(Station("S1", FCFS()))
        elif self.ui.strategyComboBox.currentText() == "EDF":
            scenario.addStation(Station("S1", EDF()))
        elif self.ui.strategyComboBox.currentText() == "RR":
            scenario.addStation(Station("S1", RoundRobin()))

        for widget in self.widgets:
            vehicle = Vehicle(name=widget.ui.nameTextEdit.toPlainText(),
                              arrival=int(widget.ui.arrivalTextEdit.toPlainText()),
                              departure=int(widget.ui.departureTextEdit.toPlainText()),
                              desiredCharge=float(widget.ui.desiredChargeTextEdit.toPlainText()))
            vehicle.getBattery().capacity = float(widget.ui.capacityTextEdit.toPlainText())
            vehicle.getBattery().chargePower = float(widget.ui.chargePowerTextEdit.toPlainText())
            vehicle.getBattery().stateOfCharge = float(widget.ui.socTextEdit.toPlainText())

            scenario.getStations()[0].addVehicle(vehicle)
        return scenario


if __name__ == "__main__":
    app = QApplication(sys.argv)

    window = MainWindow()
    window.show()

    sys.exit(app.exec())
