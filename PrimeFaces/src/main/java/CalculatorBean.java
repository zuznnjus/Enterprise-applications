/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */

import java.util.Date;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


@Named(value = "calculatorBean")
@RequestScoped
public class CalculatorBean {

    private Integer firstNumber;
    private Integer secondNumber;
    private Integer result;
    
    public CalculatorBean() {
    }

    public void addNumbers() {
        result = firstNumber + secondNumber;
        saveMessage();
    }
    
    public void saveMessage() {
        FacesContext context = FacesContext.getCurrentInstance();
        String message = String.format("%d + %d = %d", 
                firstNumber, secondNumber, result);
        context.addMessage(null, new FacesMessage(message));
    }
    
    /**
     * @return the firstNumber
     */
    public Integer getFirstNumber() {
        return firstNumber;
    }

    /**
     * @param firstNumber the firstNumber to set
     */
    public void setFirstNumber(Integer firstNumber) {
        this.firstNumber = firstNumber;
    }

    /**
     * @return the secondNumber
     */
    public Integer getSecondNumber() {
        return secondNumber;
    }

    /**
     * @param secondNumber the secondNumber to set
     */
    public void setSecondNumber(Integer secondNumber) {
        this.secondNumber = secondNumber;
    }

    /**
     * @return the result
     */
    public Integer getResult() {
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(Integer result) {
        this.result = result;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return new Date(); 
    }
}
