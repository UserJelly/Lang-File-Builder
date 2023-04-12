ECHO. > "LangFile.lang"
DIR /B /O *.txt > "ItemConfigList"
java "LangFileMaker"
DEL "ItemConfigList"