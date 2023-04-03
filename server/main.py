from flask import Flask
import os

app = Flask(__name__)


@app.route('/')
def hello():
    return 'Hello, World!'

@app.route('/apiSparkJob')
def apiSpark():
    os.system("spark-submit --class com.MiniProject --master local /home/nvanvuong1/spark/target/scala-2.12/Demo-assembly-1.8.2.jar")
    return 'Job is run!!!'