from flask import Flask, request

app = Flask(__name__)

@app.route('/', methods=['GET'])
def home():
    print(request)
    barcode = request.args.get('barcode', '')
    try:
        barcode = int(barcode)
        return str(int(barcode / 100)), 200
    except Exception as e:
        return '', 404

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5000, debug=True)
