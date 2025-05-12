from scapy.all import *

ip = "192.168.1.1"  # Target IP
packet = Ether(dst="ff:ff:ff:ff:ff:ff") / ARP(pdst=ip)

ans = srp(packet, timeout=2, verbose=0)[0]

for s, r in ans:
    print("IP:", r.psrc, "| MAC:", r.hwsrc)
