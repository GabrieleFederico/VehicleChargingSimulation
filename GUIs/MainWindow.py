import sys
import random
from PyQt5.QtWidgets import QApplication, QWidget, QMainWindow, QLabel, QDesktopWidget, QComboBox, QPushButton
from PyQt5.QtGui import QIcon

from entities.Scenario import Scenario
from entities.Station import Station
from entities.Vehicle import Vehicle
from strategies.FCFS import FCFS


class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        self.title = 'VehicleChargingSimulation'
        self.left = 10
        self.top = 10
        self.width = 1280
        self.height = 720
        self.initUI()
        self.center()
        self.scenario = Scenario()

    def initUI(self):
        self.setWindowTitle(self.title)
        self.setGeometry(self.left, self.top, self.width, self.height)

        label = QLabel('Vehicles', self)
        label.move(50, 50)

        #Somehow should make number of vehicles and order of vehicle editable
        #for now let's just try to make a simple simulation
        #vehiclesComboBoxes = []
        #vehiclesComboBoxes.append(QComboBox(self).add)


        vehiclesComboBox = QComboBox(self)
        vehiclesComboBox.addItem("V1")
        vehiclesComboBox.move(50, 100)

        label2 = QLabel('Stations', self)
        label2.move(50, 150)
        stationsComboBox = QComboBox(self)
        stationsComboBox.addItem("S1")
        stationsComboBox.move(50, 200)

        strategiesComboBox = QComboBox(self)
        strategiesComboBox.addItems(["FCFS", "EDF", "RR"])
        strategiesComboBox.move(200, 200)

        importButton = QPushButton(self)
        importButton.move(600, 600)
        importButton.setText("Import")
        #importButton.clicked().connect(self.buttonClick)

        runButton = QPushButton(self)
        runButton.move(500, 500)
        runButton.setText("Run")
        runButton.clicked.connect(self.runButtonPress)

        self.show()

    def runButtonPress(self):
        scenario = Scenario()
        scenario.addStation("S1", Station(FCFS()))
        scenario.getStations()["S1"].addVehicle(Vehicle(name="V1", arrival=1, departure=15))
        scenario.getStations()["S1"].addVehicle(Vehicle(name="V2", arrival=2))
        scenario.getStations()["S1"].addVehicle(Vehicle(name="V3", arrival=1))
        scenario.runSimulation()
        return

    def importButtonPress(self):
        pass

    def center(self):
        qr = self.frameGeometry()
        cp = QDesktopWidget().availableGeometry().center()
        qr.moveCenter(cp)
        self.move(qr.topLeft())
