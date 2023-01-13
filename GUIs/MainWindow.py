import sys
import random
from PyQt5.QtWidgets import QApplication, QWidget, QMainWindow, QLabel, QDesktopWidget, QComboBox, QPushButton
from PyQt5.QtGui import QIcon


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

    def initUI(self):
        self.setWindowTitle(self.title)
        self.setGeometry(self.left, self.top, self.width, self.height)

        label = QLabel('Vehicles', self)
        label.move(50, 50)

        vehiclesComboBox = QComboBox(self)
        vehiclesComboBox.addItem("V1")
        vehiclesComboBox.move(50, 100)

        label2 = QLabel('Stations', self)
        label2.move(50, 150)
        stationsComboBox = QComboBox(self)
        stationsComboBox.addItem("S1")
        stationsComboBox.move(50, 200)

        importButton = QPushButton(self)
        importButton.move(600, 600)
        importButton.setText("Import")
        #importButton.clicked().connect(self.buttonClick)

        runButton = QPushButton(self)
        runButton.move(500, 500)
        runButton.setText("Run")

        self.show()


    def runButtonPress(self):
        pass

    def importButtonPress(self):
        pass
    def center(self):
        qr = self.frameGeometry()
        cp = QDesktopWidget().availableGeometry().center()
        qr.moveCenter(cp)
        self.move(qr.topLeft())
