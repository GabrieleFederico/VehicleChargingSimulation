# -*- coding: utf-8 -*-

################################################################################
## Form generated from reading UI file 'MainWindow.ui'
##
## Created by: Qt User Interface Compiler version 6.4.1
##
## WARNING! All changes made in this file will be lost when recompiling UI file!
################################################################################

from PySide6.QtCore import (QCoreApplication, QDate, QDateTime, QLocale,
    QMetaObject, QObject, QPoint, QRect,
    QSize, QTime, QUrl, Qt)
from PySide6.QtGui import (QBrush, QColor, QConicalGradient, QCursor,
    QFont, QFontDatabase, QGradient, QIcon,
    QImage, QKeySequence, QLinearGradient, QPainter,
    QPalette, QPixmap, QRadialGradient, QTransform)
from PySide6.QtWidgets import (QApplication, QComboBox, QGridLayout, QMainWindow,
    QPushButton, QScrollArea, QSizePolicy, QStatusBar,
    QWidget)

class Ui_MainWindow(object):
    def setupUi(self, MainWindow):
        if not MainWindow.objectName():
            MainWindow.setObjectName(u"MainWindow")
        MainWindow.resize(814, 600)
        self.centralwidget = QWidget(MainWindow)
        self.centralwidget.setObjectName(u"centralwidget")
        self.addVehicleButton = QPushButton(self.centralwidget)
        self.addVehicleButton.setObjectName(u"addVehicleButton")
        self.addVehicleButton.setGeometry(QRect(680, 20, 101, 51))
        self.strategyComboBox = QComboBox(self.centralwidget)
        self.strategyComboBox.addItem("")
        self.strategyComboBox.addItem("")
        self.strategyComboBox.addItem("")
        self.strategyComboBox.setObjectName(u"strategyComboBox")
        self.strategyComboBox.setGeometry(QRect(680, 110, 101, 31))
        self.importPushButton = QPushButton(self.centralwidget)
        self.importPushButton.setObjectName(u"importPushButton")
        self.importPushButton.setGeometry(QRect(680, 160, 101, 31))
        self.exportPushButton = QPushButton(self.centralwidget)
        self.exportPushButton.setObjectName(u"exportPushButton")
        self.exportPushButton.setGeometry(QRect(680, 210, 101, 31))
        self.runPushButton = QPushButton(self.centralwidget)
        self.runPushButton.setObjectName(u"runPushButton")
        self.runPushButton.setGeometry(QRect(680, 260, 101, 31))
        self.scrollArea = QScrollArea(self.centralwidget)
        self.scrollArea.setObjectName(u"scrollArea")
        self.scrollArea.setGeometry(QRect(30, 30, 611, 521))
        self.scrollArea.setWidgetResizable(True)
        self.scrollAreaWidgetContents = QWidget()
        self.scrollAreaWidgetContents.setObjectName(u"scrollAreaWidgetContents")
        self.scrollAreaWidgetContents.setGeometry(QRect(0, 0, 609, 519))
        self.gridLayout = QGridLayout(self.scrollAreaWidgetContents)
        self.gridLayout.setObjectName(u"gridLayout")
        self.scrollArea.setWidget(self.scrollAreaWidgetContents)
        MainWindow.setCentralWidget(self.centralwidget)
        self.statusbar = QStatusBar(MainWindow)
        self.statusbar.setObjectName(u"statusbar")
        MainWindow.setStatusBar(self.statusbar)

        self.retranslateUi(MainWindow)

        QMetaObject.connectSlotsByName(MainWindow)
    # setupUi

    def retranslateUi(self, MainWindow):
        MainWindow.setWindowTitle(QCoreApplication.translate("MainWindow", u"MainWindow", None))
        self.addVehicleButton.setText(QCoreApplication.translate("MainWindow", u"Add Vehicle", None))
        self.strategyComboBox.setItemText(0, QCoreApplication.translate("MainWindow", u"FCFS", None))
        self.strategyComboBox.setItemText(1, QCoreApplication.translate("MainWindow", u"EDF", None))
        self.strategyComboBox.setItemText(2, QCoreApplication.translate("MainWindow", u"RR", None))

        self.importPushButton.setText(QCoreApplication.translate("MainWindow", u"Import", None))
        self.exportPushButton.setText(QCoreApplication.translate("MainWindow", u"Export", None))
        self.runPushButton.setText(QCoreApplication.translate("MainWindow", u"Run", None))
    # retranslateUi

