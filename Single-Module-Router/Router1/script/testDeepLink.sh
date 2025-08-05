#!/bin/bash

adb shell am start -W -a android.intent.action.VIEW -d "$1" cn.six.router1