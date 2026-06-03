// MainApp.java
package application;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class MainApp extends Application {
    
    private EmployeeDAO employeeDAO = new EmployeeDAO();
    private ObservableList<Employee> employeeList = FXCollections.observableArrayList();
    private TableView<Employee> tableView;
    
    // Form fields
    private TextField nameField;
    private TextField positionField;
    private TextField emailField;
    private TextField salaryField;
    private TextField searchField;
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Employee Management System");
        
        // Create main layout
        BorderPane mainLayout = new BorderPane();
        
        // Create header
        VBox header = createHeader();
        mainLayout.setTop(header);
        
        // Create center with table and form
        SplitPane centerPane = new SplitPane();
        centerPane.setDividerPositions(0.6);
        
        // Table view
        VBox tableSection = createTableSection();
        
        // Form section
        VBox formSection = createFormSection();
        
        centerPane.getItems().addAll(tableSection, formSection);
        mainLayout.setCenter(centerPane);
        
        // Load data
        loadEmployeeData();
        
        Scene scene = new Scene(mainLayout, 1200, 700);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private VBox createHeader() {
        VBox header = new VBox(10);
        header.setPadding(new Insets(10));
        header.setStyle("-fx-background-color: #2c3e50;");
        
        Label titleLabel = new Label("Employee Management System");
        titleLabel.setStyle("-fx-text-fill: white; -fx-font-size: 24px; -fx-font-weight: bold;");
        titleLabel.setAlignment(Pos.CENTER);
        titleLabel.setMaxWidth(Double.MAX_VALUE);
        
        // Search bar
        HBox searchBox = new HBox(10);
        searchBox.setAlignment(Pos.CENTER_RIGHT);
        
        Label searchLabel = new Label("Search:");
        searchLabel.setStyle("-fx-text-fill: white; -fx-font-size: 14px;");
        searchField = new TextField();
        searchField.setPromptText("Enter name or position...");
        searchField.setPrefWidth(300);
        
        Button searchButton = new Button("Search");
        searchButton.setStyle("-fx-background-color: #3498db; -fx-text-fill: white; -fx-font-weight: bold;");
        searchButton.setOnAction(e -> searchEmployees());
        
        Button refreshButton = new Button("Refresh");
        refreshButton.setStyle("-fx-background-color: #27ae60; -fx-text-fill: white; -fx-font-weight: bold;");
        refreshButton.setOnAction(e -> loadEmployeeData());
        
        searchBox.getChildren().addAll(searchLabel, searchField, searchButton, refreshButton);
        
        header.getChildren().addAll(titleLabel, searchBox);
        return header;
    }
    
    private VBox createTableSection() {
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));
        
        Label tableLabel = new Label("Employee List");
        tableLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #2c3e50;");
        
        tableView = new TableView<>();
        tableView.setPrefHeight(600);
        
        // Create columns
        TableColumn<Employee, Integer> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        idColumn.setPrefWidth(50);
        idColumn.setStyle("-fx-alignment: CENTER;");
        
        TableColumn<Employee, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameColumn.setPrefWidth(150);
        
        TableColumn<Employee, String> positionColumn = new TableColumn<>("Position");
        positionColumn.setCellValueFactory(new PropertyValueFactory<>("position"));
        positionColumn.setPrefWidth(150);
        
        TableColumn<Employee, String> emailColumn = new TableColumn<>("Email");
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        emailColumn.setPrefWidth(200);
        
        TableColumn<Employee, Double> salaryColumn = new TableColumn<>("Salary ($)");
        salaryColumn.setCellValueFactory(new PropertyValueFactory<>("salary"));
        salaryColumn.setPrefWidth(120);
        salaryColumn.setStyle("-fx-alignment: CENTER-RIGHT;");
        
        tableView.getColumns().addAll(idColumn, nameColumn, positionColumn, emailColumn, salaryColumn);
        tableView.setItems(employeeList);
        
        // Add selection listener
        tableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                populateForm(newSelection);
            }
        });
        
        vbox.getChildren().addAll(tableLabel, tableView);
        return vbox;
    }
    
    private VBox createFormSection() {
        VBox vbox = new VBox(15);
        vbox.setPadding(new Insets(20));
        vbox.setStyle("-fx-background-color: #ecf0f1; -fx-border-color: #bdc3c7; -fx-border-width: 0 0 0 1;");
        
        Label formLabel = new Label("Employee Details");
        formLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #2c3e50;");
        
        GridPane formGrid = new GridPane();
        formGrid.setHgap(10);
        formGrid.setVgap(15);
        formGrid.setPadding(new Insets(10));
        
        // Form fields
        Label nameLabel = new Label("Name:");
        nameLabel.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");
        nameField = new TextField();
        nameField.setPromptText("Enter employee name");
        nameField.setPrefHeight(35);
        
        Label positionLabel = new Label("Position:");
        positionLabel.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");
        positionField = new TextField();
        positionField.setPromptText("Enter position");
        positionField.setPrefHeight(35);
        
        Label emailLabel = new Label("Email:");
        emailLabel.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");
        emailField = new TextField();
        emailField.setPromptText("Enter email address");
        emailField.setPrefHeight(35);
        
        Label salaryLabel = new Label("Salary ($):");
        salaryLabel.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");
        salaryField = new TextField();
        salaryField.setPromptText("Enter salary amount");
        salaryField.setPrefHeight(35);
        
        formGrid.add(nameLabel, 0, 0);
        formGrid.add(nameField, 1, 0);
        formGrid.add(positionLabel, 0, 1);
        formGrid.add(positionField, 1, 1);
        formGrid.add(emailLabel, 0, 2);
        formGrid.add(emailField, 1, 2);
        formGrid.add(salaryLabel, 0, 3);
        formGrid.add(salaryField, 1, 3);
        
        // Buttons
        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setPadding(new Insets(10, 0, 0, 0));
        
        Button addButton = new Button("Add Employee");
        addButton.setStyle("-fx-background-color: #27ae60; -fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 13px;");
        addButton.setPrefWidth(120);
        addButton.setOnAction(e -> addEmployee());
        
        Button updateButton = new Button("Update Salary");
        updateButton.setStyle("-fx-background-color: #3498db; -fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 13px;");
        updateButton.setPrefWidth(120);
        updateButton.setOnAction(e -> updateSalary());
        
        Button updateAllButton = new Button("Update All");
        updateAllButton.setStyle("-fx-background-color: #f39c12; -fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 13px;");
        updateAllButton.setPrefWidth(120);
        updateAllButton.setOnAction(e -> updateEmployee());
        
        Button deleteButton = new Button("Delete");
        deleteButton.setStyle("-fx-background-color: #e74c3c; -fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 13px;");
        deleteButton.setPrefWidth(120);
        deleteButton.setOnAction(e -> deleteEmployee());
        
        Button clearButton = new Button("Clear");
        clearButton.setStyle("-fx-background-color: #95a5a6; -fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 13px;");
        clearButton.setPrefWidth(120);
        clearButton.setOnAction(e -> clearForm());
        
        buttonBox.getChildren().addAll(addButton, updateButton, updateAllButton, deleteButton, clearButton);
        
        vbox.getChildren().addAll(formLabel, formGrid, buttonBox);
        return vbox;
    }
    
    private void loadEmployeeData() {
        employeeList.clear();
        employeeList.addAll(employeeDAO.getAllEmployees());
    }
    
    private void searchEmployees() {
        String searchText = searchField.getText().toLowerCase();
        if (searchText.isEmpty()) {
            loadEmployeeData();
        } else {
            ObservableList<Employee> filteredList = FXCollections.observableArrayList();
            for (Employee emp : employeeDAO.getAllEmployees()) {
                if (emp.getName().toLowerCase().contains(searchText) ||
                    emp.getPosition().toLowerCase().contains(searchText)) {
                    filteredList.add(emp);
                }
            }
            employeeList.setAll(filteredList);
        }
    }
    
    private void populateForm(Employee employee) {
        nameField.setText(employee.getName());
        positionField.setText(employee.getPosition());
        emailField.setText(employee.getEmail());
        salaryField.setText(String.valueOf(employee.getSalary()));
    }
    
    private void addEmployee() {
        if (!validateInputs()) return;
        
        try {
            Employee employee = new Employee();
            employee.setName(nameField.getText());
            employee.setPosition(positionField.getText());
            employee.setEmail(emailField.getText());
            employee.setSalary(Double.parseDouble(salaryField.getText()));
            
            if (employeeDAO.insertEmployee(employee)) {
                showAlert(Alert.AlertType.INFORMATION, "Success", "Employee added successfully!\nEmployee ID: " + employee.getId());
                loadEmployeeData();
                clearForm();
            } else {
                showAlert(Alert.AlertType.ERROR, "Error", "Failed to add employee. Email might already exist!");
            }
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Error", "Invalid salary format! Please enter a valid number.");
        }
    }
    
    private void updateSalary() {
        Employee selected = tableView.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert(Alert.AlertType.WARNING, "No Selection", "Please select an employee to update salary!");
            return;
        }
        
        TextInputDialog dialog = new TextInputDialog(String.valueOf(selected.getSalary()));
        dialog.setTitle("Update Salary");
        dialog.setHeaderText("Update salary for: " + selected.getName());
        dialog.setContentText("New Salary ($):");
        
        dialog.showAndWait().ifPresent(newSalary -> {
            try {
                double salary = Double.parseDouble(newSalary);
                if (employeeDAO.updateSalary(selected.getId(), salary)) {
                    showAlert(Alert.AlertType.INFORMATION, "Success", "Salary updated successfully!\nNew Salary: $" + salary);
                    loadEmployeeData();
                } else {
                    showAlert(Alert.AlertType.ERROR, "Error", "Failed to update salary!");
                }
            } catch (NumberFormatException e) {
                showAlert(Alert.AlertType.ERROR, "Error", "Invalid salary format!");
            }
        });
    }
    
    private void updateEmployee() {
        Employee selected = tableView.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert(Alert.AlertType.WARNING, "No Selection", "Please select an employee to update!");
            return;
        }
        
        if (!validateInputs()) return;
        
        try {
            selected.setName(nameField.getText());
            selected.setPosition(positionField.getText());
            selected.setEmail(emailField.getText());
            selected.setSalary(Double.parseDouble(salaryField.getText()));
            
            if (employeeDAO.updateEmployee(selected)) {
                showAlert(Alert.AlertType.INFORMATION, "Success", "Employee updated successfully!");
                loadEmployeeData();
                clearForm();
            } else {
                showAlert(Alert.AlertType.ERROR, "Error", "Failed to update employee!");
            }
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Error", "Invalid salary format!");
        }
    }
    
    private void deleteEmployee() {
        Employee selected = tableView.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert(Alert.AlertType.WARNING, "No Selection", "Please select an employee to delete!");
            return;
        }
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirm Delete");
        alert.setHeaderText("Delete Employee");
        alert.setContentText("Are you sure you want to delete " + selected.getName() + "?");
        
        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                if (employeeDAO.deleteEmployee(selected.getId())) {
                    showAlert(Alert.AlertType.INFORMATION, "Success", "Employee deleted successfully!");
                    loadEmployeeData();
                    clearForm();
                } else {
                    showAlert(Alert.AlertType.ERROR, "Error", "Failed to delete employee!");
                }
            }
        });
    }
    
    private boolean validateInputs() {
        if (nameField.getText().trim().isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Validation Error", "Name is required!");
            nameField.requestFocus();
            return false;
        }
        if (positionField.getText().trim().isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Validation Error", "Position is required!");
            positionField.requestFocus();
            return false;
        }
        if (emailField.getText().trim().isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Validation Error", "Email is required!");
            emailField.requestFocus();
            return false;
        }
        if (!emailField.getText().contains("@")) {
            showAlert(Alert.AlertType.WARNING, "Validation Error", "Please enter a valid email address!");
            emailField.requestFocus();
            return false;
        }
        if (salaryField.getText().trim().isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Validation Error", "Salary is required!");
            salaryField.requestFocus();
            return false;
        }
        try {
            double salary = Double.parseDouble(salaryField.getText());
            if (salary < 0) {
                showAlert(Alert.AlertType.WARNING, "Validation Error", "Salary cannot be negative!");
                return false;
            }
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.WARNING, "Validation Error", "Please enter a valid salary amount!");
            return false;
        }
        return true;
    }
    
    private void clearForm() {
        nameField.clear();
        positionField.clear();
        emailField.clear();
        salaryField.clear();
        tableView.getSelectionModel().clearSelection();
    }
    
    private void showAlert(Alert.AlertType type, String title, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}