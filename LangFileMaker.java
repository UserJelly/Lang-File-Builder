import java.io.BufferedReader ;
import java.io.BufferedWriter ;
import java.io.FileReader ;
import java.io.FileWriter ;
import java.io.IOException ;

import static java.lang.System.out ;

public class LangFileMaker
{
	public static String makingNameContext(String ConfigFileName)
	{
		String NewLineContext = "";
		try
		{
			FileReader FileReadding = new FileReader(ConfigFileName) ;
			BufferedReader ConfigFileReader = new BufferedReader(FileReadding) ;
			
			String LineContext = "";
			
			String NewLine = "" ;
			String Name = "", ShortName = "" ;
			String ItemName = "", ItemShortName = "";
			
			while((LineContext = ConfigFileReader.readLine())!=null)
			{
				if(!(LineContext.length()>5))
					continue ;
				
				Name = ShortName = ""; 
				
				for(int i = 0 ; i<=4 ; i++)
					Name+=LineContext.charAt(i) ;
				
				if(LineContext.length()>10)
					for(int i = 0 ; i<10; i++)
						ShortName+=LineContext.charAt(i) ;
				
				if(Name.equals("Name "))
				{
					for(int i = 5 ; i<LineContext.length() ; i++)
						ItemName += LineContext.charAt(i) ;
				}
				
				if(ShortName.equals("ShortName "))
				{
					for(int i = 10 ; i<LineContext.length() ; i++)
						ItemShortName+=LineContext.charAt(i) ;
				}
			}
			
			FileReadding.close() ;
			ConfigFileReader.close() ;
			
			NewLineContext = "item."+ItemShortName+".name="+ItemName ;
			
		}
		catch(IOException E)
		{
			NewLineContext = "Jz" ;
		}
		return NewLineContext ;
	}
	
	public static void main(String[] args)
	{
		try
		{
			FileReader FileReaderStreamObj = new FileReader("ItemConfigList");
			BufferedReader ConfigFileListReader = new BufferedReader(FileReaderStreamObj);
			
			FileWriter FileWritting = new FileWriter("LangFile.lang") ;
			BufferedWriter WritFile = new BufferedWriter(FileWritting) ;
			
			String ItemConfigFileName = "";
			
			while((ItemConfigFileName = ConfigFileListReader.readLine())!=null)
			{
				String T = makingNameContext(ItemConfigFileName)+"\n" ;
				WritFile.write(T,0,T.length()) ;
			}
			String BaseLine = "--------------------------------------------------------------" ;
			WritFile.write(BaseLine,0,BaseLine.length()) ;
			FileReaderStreamObj.close();
			ConfigFileListReader.close();
			
			WritFile.close();
			FileWritting.close();
		}
		catch(IOException E)
		{
			E.printStackTrace() ;
		}
		
	}
}