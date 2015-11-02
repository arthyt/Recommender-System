
library(ggplot2)
library(tm)
library(wordcloud)
library(RColorBrewer)
setwd("/Users/arthythirupathysamy/Documents/Incubator")

data <- read.table("moviestext.txt",sep=",",header=FALSE,fill=TRUE,nrow=5000,stringsAsFactors=FALSE)
data <- data[,1:7]
headclasses1 = sapply(data, class)
column.name <- c("id","user","profilename","helpful","rating","time","summary","review")
column.type <- c(rep("factor",4),"numeric",rep("factor,3"))

data[data$V1==" B00008G1PX" ,5]
str(data)


p1 <-qplot(data[data$V1==" B00008G1PX",5],ß
      geom="histogram",
      binwidth = 0.5,  
      main = "Movie - B00008G1PX ", 
      xlab = "Rating",  
      fill=I("turquoise3"), 
      col=I("turquoise3") )

p2<-qplot(data[data$V1==" B000063W1R",5],
      geom="histogram",
      binwidth = 0.5,  
      main = "Movie - B000063W1R ", 
      xlab = "Rating",  
      fill=I("coral1"), 
      col=I("coral1"))

p3 <- qplot(data[data$V1==" B000ANVPPQ",5],
      geom="histogram",
      binwidth = 0.5,  
      main = "B000ANVPPQ", 
      xlab = "Rating",  
      fill=I("coral1"), 
      col=I("coral1"))

multiplot(p1,p3,cols=2)

#Loading Packages
review <- paste(data[data$V1==" B00008G1PX",8],collapse="")
rsource <- VectorSource(review)
corpus <- Corpus(rsource)
corpus <- tm_map(corpus, content_transformer(tolower))
corpus <- tm_map(corpus, removePunctuation)
corpus <- tm_map(corpus, stripWhitespace)
corpus <- tm_map(corpus, removeWords, stopwords("english"))
dtm <- DocumentTermMatrix(corpus)
dtm2 <- as.matrix(dtm)
frequency <- colSums(dtm2)
frequency <- sort(frequency, decreasing=TRUE)
words <- names(frequency)
dark2 <- brewer.pal(6, "Dark2")   
g1 <- wordcloud(words[1:100], frequency[1:100],max.words=100, rot.per=0.2, colors=dark2)

review1 <- paste(data[data$V1==" B000063W1R",8],collapse="")
rsource1 <- VectorSource(review1)
corpus1 <- Corpus(rsource1)
corpus1 <- tm_map(corpus1, content_transformer(tolower))
corpus1 <- tm_map(corpus1, removePunctuation)
corpus1 <- tm_map(corpus1, stripWhitespace)
corpus1 <- tm_map(corpus1, removeWords, stopwords("english"))
dtm_1 <- DocumentTermMatrix(corpus1)
dtm2_1<- as.matrix(dtm_1)
frequency1 <- colSums(dtm2_1)
frequency1 <- sort(frequency1, decreasing=TRUE)
words1 <- names(frequency1)
dark2 <- brewer.pal(6, "Dark2")   
g2 <- wordcloud(words1[1:100], frequency1[1:100],max.words=100, rot.per=0.2, colors=dark2)

multiplot(g1,g2,col=2)
