#!/bin/bash
sudo kill $(ps -aux | grep 'collecting' | awk 'NR==2{print $2}')