# coding=utf-8

import requests
from flask import json
from requests.auth import HTTPBasicAuth

try:
    auth = requests.post(
        url='http://localhost:9094/oauth/token',
        data={'grant_type': 'password', 'username': 'vnaraujo', 'password': '123'},
        auth=HTTPBasicAuth('manager', 'xpto')
    )
    if auth.status_code == 200:
        host = 'http://localhost:9095'
        header = {
            'Host': host,
            'Content-Type': 'application/json',
            'token': auth.text,
            'Cache-Control': 'no-cache'
        }
        result = requests.get(url='{}/api/v1/resource/home'.format(host), headers=header)
        print(result)
except ValueError as ex:
    print(ex)
