package application;

import java.util.ArrayList;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class SampleController 
{
	
	String noir = "-fx-background-color : black";
	String blanc = "-fx-background-color : white";
	
	@FXML
    private GridPane grid;
	
	@FXML
    private JFXButton startBtn;
	
	@FXML
    private JFXButton nextBtn;

    @FXML
    void start(ActionEvent event) 
    {
    	AnchorPane a;
    	for(int i=0;i<35;i++)
    	{
    		for(int j=0;j<25;j++)
    		{
    			a = new AnchorPane();
    	    	//if (((i==3)&&(j==5))||((i==4)&&(j==5))||((i==5)&&(j==5))||((i==6)&&(j==5))||((i==7)&&(j==5))||((i==4)&&(j==4))) a.setStyle(noir);
    			//if (((i==3)&&(j==5))||((i==4)&&(j==5))||((i==5)&&(j==5))) a.setStyle(noir);
    			//if (((i==3)&&(j==5))||((i==4)&&(j==5))||((i==5)&&(j==5))||((i==6)&&(j==5))) a.setStyle(noir);
    			//if (((i==3)&&(j==5))||((i==4)&&(j==5))||((i==5)&&(j==5))||((i==6)&&(j==5))||((i==7)&&(j==5))) a.setStyle(noir);
    			//if (((i==3)&&(j==5))||((i==4)&&(j==5))||((i==3)&&(j==4))||((i==4)&&(j==4))||((i==3)&&(j==3))) a.setStyle(noir);
    			//if (((i==15)&&(j==18))||((i==15)&&(j==15))||((i==16)&&(j==15))||((i==14)&&(j==17))||((i==14)&&(j==16))||((i==16)&&(j==17))||((i==16)&&(j==16))) a.setStyle(noir);
    			if (((i==18)&&(j==18))||((i==18)&&(j==17))||((i==18)&&(j==16))||((i==19)&&(j==16))||((i==17)&&(j==17))) a.setStyle(noir);
    			//if (((i==12)&&(j==12))||((i==13)&&(j==12))||((i==14)&&(j==12))||((i==15)&&(j==12))||((i==16)&&(j==12))||((i==17)&&(j==12))||((i==18)&&(j==12))||((i==19)&&(j==12))||((i==20)&&(j==12))||((i==21)&&(j==12))) a.setStyle(noir);
    	    	else a.setStyle(blanc);
    	    	grid.add(a, i, j);
    		}
    	}
    	startBtn.setDisable(true);
    	nextBtn.setDisable(false);
    }
    
    @FXML
    void next(ActionEvent event) 
    {
    	AnchorPane a;
    	ArrayList<AnchorPane> list = new ArrayList<AnchorPane>();
    	for(int i=0;i<35;i++)
    	{
    		for(int j=0;j<25;j++)
    		{
    			int nbVoisines = nbVoisines(i,j);
    			a = (AnchorPane) grid.getChildren().get(i*25+j+1);
    			if ((nbVoisines!=2)&&(nbVoisines!=3)&&(a.getStyle().equals(noir))) list.add(a);
    			if ((nbVoisines==3)&&(a.getStyle().equals(blanc))) list.add(a);
    		}
    	}
    	for (int k=0;k<list.size();k++)
    	{
    		a = list.get(k);
    		if (a.getStyle().equals(noir)) a.setStyle(blanc);
    		else a.setStyle(noir);
    	}
    }
    
    public int nbVoisines(int i,int j)
    {
    	int nb = 0;
    	if (j+1<25)
    	{
    		if (((AnchorPane) grid.getChildren().get(i*25+j+1+1)).getStyle().equals(noir)) nb++; 
    	}
    	if (0<j)
    	{
    		if (((AnchorPane) grid.getChildren().get(i*25+j-1+1)).getStyle().equals(noir)) nb++; 
    	}
    	if (i+1<35)
    	{
    		if (((AnchorPane) grid.getChildren().get((i+1)*25+j+1)).getStyle().equals(noir)) nb++; 
    	}
    	if (0<i)
    	{
    		if (((AnchorPane) grid.getChildren().get((i-1)*25+j+1)).getStyle().equals(noir)) nb++; 
    	}
    	if ((0<i)&&(0<j))
    	{
    		if (((AnchorPane) grid.getChildren().get((i-1)*25+j-1+1)).getStyle().equals(noir)) nb++; 
    	}
    	if ((j+1<25)&&(i+1<35))
    	{
    		if (((AnchorPane) grid.getChildren().get((i+1)*25+j+1+1)).getStyle().equals(noir)) nb++; 
    	}
    	if ((j+1<25)&&(0<i))
    	{
    		if (((AnchorPane) grid.getChildren().get((i-1)*25+j+1+1)).getStyle().equals(noir)) nb++; 
    	}
    	if ((i+1<35)&&(0<j))
    	{
    		if (((AnchorPane) grid.getChildren().get((i+1)*25+j-1+1)).getStyle().equals(noir)) nb++; 
    	}
    	return nb;
    }

}
