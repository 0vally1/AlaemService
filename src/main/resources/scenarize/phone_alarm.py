#!/usr/bin/python
# coding=utf-8

import sys, getopt
import json
import requests
import time

call_center="http://192.168.88.49:8085/call/phone"

def InitialStrategys():
    PhoneBook.register("Type.VALLEY", "***********")


class PhoneBook(object):
    strategy = {}

    @classmethod
    def get_strategy_by_type(cls, type):
        return cls.strategy.get(type)

    @classmethod
    def register(cls, strategy_type, strategy):
        if strategy_type == "":
            print(-2)
        cls.strategy[strategy_type] = strategy


def main(argv):
    try:
        opts, args = getopt.getopt(argv, "hp:", ["help", "personnel="])
    except getopt.GetoptError:
        sys.exit()
    if len(opts) <= 0:
        sys.exit()
    personnel = None
    for opt, arg in opts:
        if opt == '-h':
            sys.exit()
        elif opt in ("-p", "--personnel"):
            personnel = arg
        else:
            sys.exit()
    if personnel is None:
        sys.exit()

    InitialStrategys()
    strategy = PhoneBook.get_strategy_by_type(personnel)
    if not strategy:
        sys.exit()

    try:
        req_body_json = {"phone": strategy + ""}
        r = requests.post(call_center, json=req_body_json)
        if r.status_code == requests.codes.ok:
            pass
        else:
            print(-1)
        data_json = json.loads(r.text)
        code = data_json["code"]
        if code == '200':
            print(1)
        else:
            print(0)
    except Exception as err:
        print(-1)
    finally:
        pass


if __name__ == '__main__':
    main(sys.argv[1:])
