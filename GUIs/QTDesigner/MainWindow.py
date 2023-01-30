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
from PySide6.QtWidgets import (QApplication, QComboBox, QMainWindow, QMenuBar,
    QPushButton, QSizePolicy, QStatusBar, QVBoxLayout,
    QWidget)

class Ui_MainWindow(object):
    def setupUi(self, MainWindow):
        if not MainWindow.objectName():
            MainWindow.setObjectName(u"MainWindow")
        MainWindow.resize(800, 600)
        self.centralwidget = QWidget(MainWindow)
        self.centralwidget.setObjectName(u"centralwidget")
        self.verticalLayoutWidget = QWidget(self.centralwidget)
        self.verticalLayoutWidget.setObjectName(u"verticalLayoutWidget")
        self.verticalLayoutWidget.setGeometry(QRect(20, 10, 251, 501))
        self.verticalLayout = QVBoxLayout(self.verticalLayoutWidget)
        self.verticalLayout.setObjectName(u"verticalLayout")
        self.verticalLayout.setContentsMargins(0, 0, 0, 0)
        self.addVehicleButton = QPushButton(self.centralwidget)
        self.addVehicleButton.setObjectName(u"addVehicleButton")
        self.addVehicleButton.setGeometry(QRect(280, 20, 101, 51))
        self.strategyComboBox = QComboBox(self.centralwidget)
        self.strategyComboBox.addItem("")
        self.strategyComboBox.addItem("")
        self.strategyComboBox.addItem("")
        self.strategyComboBox.setObjectName(u"strategyComboBox")
        self.strategyComboBox.setGeometry(QRect(280, 110, 101, 31))
        self.importPushButton = QPushButton(self.centralwidget)
        self.importPushButton.setObjectName(u"importPushButton")
        self.importPushButton.setGeometry(QRect(280, 160, 101, 31))
        self.exportPushButton = QPushButton(self.centralwidget)
        self.exportPushButton.setObjectName(u"exportPushButton")
        self.exportPushButton.setGeometry(QRect(280, 210, 101, 31))
        self.runPushButton = QPushButton(self.centralwidget)
        self.runPushButton.setObjectName(u"runPushButton")
        self.runPushButton.setGeometry(QRect(280, 260, 101, 31))
        MainWindow.setCentralWidget(self.centralwidget)
        self.menubar = QMenuBar(MainWindow)
        self.menubar.setObjectName(u"menubar")
        self.menubar.setGeometry(QRect(0, 0, 800, 22))
        MainWindow.setMenuBar(self.menubar)
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

