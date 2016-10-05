# coding=utf-8

import requests
from requests.auth import HTTPBasicAuth


def get_auth_token():
    url = 'http://localhost:9094/oauth/token'
    data = {'grant_type': 'password', 'username': 'vnaraujo', 'password': '123'}
    auth = HTTPBasicAuth('manager', 'xpto')
    response = requests.post(url=url, data=data, auth=auth)
    if response.status_code == 200:
        return response.json()
    raise ValueError(response.content)


def test_api():
    auth = get_auth_token()
    resource_api_host = 'http://localhost:9095/'
    headers = {
        'Content-Type': 'application/json',
        'Authorization': '{} {}'.format(auth['token_type'], auth['access_token'])
    }
    response = requests.get(url='{}api/v1/home/get'.format(resource_api_host), headers=headers)
    print 'status code "%s" -> result "%s"' % (response.status_code, response.content)


test_api()
