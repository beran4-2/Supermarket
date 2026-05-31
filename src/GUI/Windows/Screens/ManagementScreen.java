package GUI.Windows.Screens;

import Data.Entities.Employee;
import Data.Entities.EmployeeRole;
import GUI.Customs.CustomButton;
import GUI.Customs.CustomWindow;
import Logic.GameManager;

import javax.swing.*;
import java.awt.*;

public class ManagementScreen {

    private JPanel managementBackground;
    private JButton backButton;
    private JLabel balanceLabel;

    private JLabel storageCapLabel;
    private JLabel shelvesCapLabel;

    private JLabel storagePriceLabel;
    private JLabel shelvesPriceLabel;

    private JLabel numRestockersLabel;
    private JLabel numOrderersLabel;
    private JLabel totalSalaryLabel;

    private GameManager gameManager;

    private int monitorWidth;
    private int monitorHeight;

    public ManagementScreen(CustomWindow customWindow, GameManager gameManager) {
        this.gameManager = gameManager;
        this.monitorWidth = CustomWindow.getMonitorWidth();
        this.monitorHeight = CustomWindow.getMonitorHeight();

        managementBackground = customWindow.paintBackground("/pictures/MainGameBackground/MainManagementBackground.png");
        managementBackground.setLayout(null);

        balanceLabel = new JLabel();
        balanceLabel.setFont(new Font("Arial", Font.BOLD, (int)(monitorHeight * 0.03)));
        balanceLabel.setForeground(new Color(119, 56, 35));
        balanceLabel.setHorizontalAlignment(SwingConstants.CENTER);

        int balW = (int)(monitorWidth * 0.4);
        int balH = (int)(monitorHeight * 0.05);
        int balX = (monitorWidth / 2) - (balW / 2);
        int balY = (int)(monitorHeight * 0.24);
        balanceLabel.setBounds(balX, balY, balW, balH);
        managementBackground.add(balanceLabel);

        int fontSize = (int)(monitorHeight * 0.025);
        int titleFontSize = (int)(monitorHeight * 0.035);

        int colWidth = (int)(monitorWidth * 0.28);
        int upgX = (int)(monitorWidth * 0.15);
        int statsX = (int)(monitorWidth * 0.36);
        int staffX = (int)(monitorWidth * 0.58);
        int yPos = (int)(monitorHeight * 0.35);
        int heightPnl = (int)(monitorHeight * 0.63);

        JPanel upgradesPanel = new JPanel();
        upgradesPanel.setLayout(new BoxLayout(upgradesPanel, BoxLayout.Y_AXIS));
        upgradesPanel.setOpaque(false);

        JPanel upgradesWrapper = new JPanel(new BorderLayout());
        upgradesWrapper.setOpaque(false);
        upgradesWrapper.add(upgradesPanel, BorderLayout.NORTH);
        upgradesWrapper.setBounds(upgX, yPos, colWidth, heightPnl);
        managementBackground.add(upgradesWrapper);

        JLabel upgradesTitle = new JLabel("Store Upgrades");
        upgradesTitle.setFont(new Font("Arial", Font.BOLD, titleFontSize));
        upgradesTitle.setForeground(Color.WHITE);
        upgradesTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        upgradesPanel.add(upgradesTitle);

        JPanel storageCell = new JPanel();
        storageCell.setLayout(new BoxLayout(storageCell, BoxLayout.Y_AXIS));
        storageCell.setOpaque(false);

        JButton upgStorageBtn = new CustomButton();
        CustomButton.buttonImage(upgStorageBtn, "/pictures/MainGameBackground/Storage100Button.png",
                (int)(monitorWidth * 0.15),
                (int)(monitorHeight * 0.08));
        upgStorageBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        upgStorageBtn.addActionListener(e -> {
            if (gameManager.upgradeStorage()) {
                updateUI();
            }
        });
        storageCell.add(upgStorageBtn);

        storageCapLabel = new JLabel();
        storageCapLabel.setFont(new Font("Arial", Font.BOLD, fontSize));
        storageCapLabel.setForeground(Color.WHITE);
        storageCapLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        storageCell.add(storageCapLabel);

        storagePriceLabel = new JLabel();
        storagePriceLabel.setFont(new Font("Arial", Font.BOLD, fontSize));
        storagePriceLabel.setForeground(new Color(119, 56, 35));
        storagePriceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        storageCell.add(storagePriceLabel);

        upgradesPanel.add(storageCell);

        JPanel shelvesCell = new JPanel();
        shelvesCell.setLayout(new BoxLayout(shelvesCell, BoxLayout.Y_AXIS));
        shelvesCell.setOpaque(false);

        JButton upgShelvesBtn = new CustomButton();
        CustomButton.buttonImage(upgShelvesBtn, "/pictures/MainGameBackground/Shelves100Button.png",
                (int)(monitorWidth * 0.15),
                (int)(monitorHeight * 0.08));
        upgShelvesBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        upgShelvesBtn.addActionListener(e -> {
            if (gameManager.upgradeShelves()) {
                updateUI();
            }
        });
        shelvesCell.add(upgShelvesBtn);

        shelvesCapLabel = new JLabel();
        shelvesCapLabel.setFont(new Font("Arial", Font.BOLD, fontSize));
        shelvesCapLabel.setForeground(Color.WHITE);
        shelvesCapLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        shelvesCell.add(shelvesCapLabel);

        shelvesPriceLabel = new JLabel();
        shelvesPriceLabel.setFont(new Font("Arial", Font.BOLD, fontSize));
        shelvesPriceLabel.setForeground(new Color(119, 56, 35));
        shelvesPriceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        shelvesCell.add(shelvesPriceLabel);

        upgradesPanel.add(shelvesCell);

        JPanel statsPanel = new JPanel();
        statsPanel.setLayout(new BoxLayout(statsPanel, BoxLayout.Y_AXIS));
        statsPanel.setOpaque(false);

        JPanel statsWrapper = new JPanel(new BorderLayout());
        statsWrapper.setOpaque(false);
        statsWrapper.add(statsPanel, BorderLayout.NORTH);
        statsWrapper.setBounds(statsX, yPos, colWidth, heightPnl);
        managementBackground.add(statsWrapper);

        JLabel statsTitle = new JLabel("Staff Stats");
        statsTitle.setFont(new Font("Arial", Font.BOLD, titleFontSize));
        statsTitle.setForeground(Color.WHITE);
        statsTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        statsPanel.add(statsTitle);

        numRestockersLabel = new JLabel();
        numRestockersLabel.setFont(new Font("Arial", Font.BOLD, fontSize));
        numRestockersLabel.setForeground(Color.WHITE);
        numRestockersLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        statsPanel.add(numRestockersLabel);

        numOrderersLabel = new JLabel();
        numOrderersLabel.setFont(new Font("Arial", Font.BOLD, fontSize));
        numOrderersLabel.setForeground(Color.WHITE);
        numOrderersLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        statsPanel.add(numOrderersLabel);

        totalSalaryLabel = new JLabel();
        totalSalaryLabel.setFont(new Font("Arial", Font.BOLD, fontSize));
        totalSalaryLabel.setForeground(new Color(119, 56, 35));
        totalSalaryLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        statsPanel.add(totalSalaryLabel);

        JPanel staffPanel = new JPanel();
        staffPanel.setLayout(new BoxLayout(staffPanel, BoxLayout.Y_AXIS));
        staffPanel.setOpaque(false);

        JPanel staffWrapper = new JPanel(new BorderLayout());
        staffWrapper.setOpaque(false);
        staffWrapper.add(staffPanel, BorderLayout.NORTH);
        staffWrapper.setBounds(staffX, yPos, colWidth, heightPnl);
        managementBackground.add(staffWrapper);

        JLabel staffTitle = new JLabel("Hire Staff");
        staffTitle.setFont(new Font("Arial", Font.BOLD, titleFontSize));
        staffTitle.setForeground(Color.WHITE);
        staffTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        staffPanel.add(staffTitle);

        Employee restockerData = null;
        Employee ordererData = null;
        for (Employee emp : gameManager.getEmployees()) {
            if (emp.getRole() == EmployeeRole.RESTOCKER) restockerData = emp;
            if (emp.getRole() == EmployeeRole.ORDERER) ordererData = emp;
        }

        if (restockerData != null) {
            JPanel restockerCell = new JPanel();
            restockerCell.setLayout(new BoxLayout(restockerCell, BoxLayout.Y_AXIS));
            restockerCell.setOpaque(false);

            int rPrice = restockerData.getInstantPrice();
            int rSal = restockerData.getSalary();
            Employee finalRestockerData = restockerData;

            JButton hireRestockerBtn = new CustomButton();
            CustomButton.buttonImage(hireRestockerBtn, "/pictures/MainGameBackground/HireRestockerButton.png",
                    (int)(monitorWidth * 0.15),
                    (int)(monitorHeight * 0.08));
            hireRestockerBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
            hireRestockerBtn.addActionListener(e -> {
                if (gameManager.hireEmployee(finalRestockerData)) {
                    updateUI();
                }
            });
            restockerCell.add(hireRestockerBtn);

            JLabel restockerSalLabel = new JLabel("Salary: $" + rSal);
            restockerSalLabel.setFont(new Font("Arial", Font.BOLD, fontSize));
            restockerSalLabel.setForeground(Color.WHITE);
            restockerSalLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            restockerCell.add(restockerSalLabel);

            JLabel restockerPriceLabel = new JLabel("$" + rPrice);
            restockerPriceLabel.setFont(new Font("Arial", Font.BOLD, fontSize));
            restockerPriceLabel.setForeground(new Color(119, 56, 35));
            restockerPriceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            restockerCell.add(restockerPriceLabel);
            staffPanel.add(restockerCell);
        }

        if (ordererData != null) {
            JPanel ordererCell = new JPanel();
            ordererCell.setLayout(new BoxLayout(ordererCell, BoxLayout.Y_AXIS));
            ordererCell.setOpaque(false);

            int oPrice = ordererData.getInstantPrice();
            int oSal = ordererData.getSalary();
            Employee finalOrdererData = ordererData;

            JButton hireOrdererBtn = new CustomButton();
            CustomButton.buttonImage(hireOrdererBtn, "/pictures/MainGameBackground/HireOrdererButton.png",
                    (int)(monitorWidth * 0.15),
                    (int)(monitorHeight * 0.08));
            hireOrdererBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
            hireOrdererBtn.addActionListener(e -> {
                if (gameManager.hireEmployee(finalOrdererData)) {
                    updateUI();
                }
            });
            ordererCell.add(hireOrdererBtn);

            JLabel ordererSalLabel = new JLabel("Salary: $" + oSal);
            ordererSalLabel.setFont(new Font("Arial", Font.BOLD, fontSize));
            ordererSalLabel.setForeground(Color.WHITE);
            ordererSalLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            ordererCell.add(ordererSalLabel);

            JLabel ordererPriceLabel = new JLabel("$" + oPrice);
            ordererPriceLabel.setFont(new Font("Arial", Font.BOLD, fontSize));
            ordererPriceLabel.setForeground(new Color(119, 56, 35));
            ordererPriceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            ordererCell.add(ordererPriceLabel);

            staffPanel.add(ordererCell);
        }

        int backButtonW = (int) (monitorWidth * 0.1822);
        int backButtonH = (int) (monitorHeight * 0.1638);
        int backButtonX = (int) (monitorWidth * 0.0156);
        int backButtonY = (int) (monitorHeight * 0.8333);

        backButton = new CustomButton();
        CustomButton.buttonImage(backButton, "/pictures/BackButton.png", backButtonW, backButtonH);
        backButton.setLocation(backButtonX, backButtonY);
        managementBackground.add(backButton);

        updateUI();
    }

    public void updateUI() {
        balanceLabel.setText("Current Balance: $ " + gameManager.getCurrentBalance());
        storageCapLabel.setText("current Storage: " + gameManager.getStoreManager().getMaxTotalStorage());
        shelvesCapLabel.setText("current Shelves: " + gameManager.getStoreManager().getMaxTotalShelves());

        storagePriceLabel.setText("$" + gameManager.getData().getSettings().getUpgrade100StoragePrice());
        shelvesPriceLabel.setText("$" + gameManager.getData().getSettings().getUpgrade100ShelvesPrice());

        int restockerCount = 0;
        int ordererCount = 0;
        int totalSalary = 0;

        for (Employee emp : gameManager.getHiredEmployees()) {
            if (emp.getRole() == EmployeeRole.RESTOCKER) {
                restockerCount++;
            } else if (emp.getRole() == EmployeeRole.ORDERER) {
                ordererCount++;
            }
            totalSalary += emp.getSalary();
        }

        numRestockersLabel.setText("Restockers: " + restockerCount);
        numOrderersLabel.setText("Orderers: " + ordererCount);
        totalSalaryLabel.setText("Total Salary: $" + totalSalary);
    }

    public JPanel getManagementBackground() {
        return managementBackground;
    }

    public JButton getBackButton() {
        return backButton;
    }
}