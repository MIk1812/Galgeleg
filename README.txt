Galgeleg af s183913, Mikkel Danielsen. D. 7/1/2021

Værd at bemærke:
- Hvis netværk fejler, vil de prædefinerede ord stadig være tilgeængelige
- Der er brugt state-pattern og singleton-pattern på programlogikken
- Der er brugt en del kræfter på at få backstacken til at fungere korrekt
- Det er muligt forlade et spil, tjekke highscoren og efterfølgende vende tilbage, takket været singleton-mønsteret
- High scores gennems i en lokal fil kaldet "highscores.txt"
- Tanken bag highscoreslisten er: et lille ord er svært at gætte men kræver ikke så mange gæt i alt; et stort ord er nemmere at gætte men kræver mange gæt i alt. Dermed kan man argumentere for, at det samlede antal er gæt er en god måde at sammenligne præstationer. 