#Skript zum Überprüfen, ob die Virtuelle Maschine schon läuft


#Zeige alle VMs und schreibe Ausgabe in die running.file
onevm list>/var/lib/one/running.file

#Schneide die Zeile mit der bekannten VM $vm.name aus and schreibe es in die Datei
#here: ttylinux = $vm.name
awk '/'$1'/ {print>"/var/lib/one/running.file"}' /var/lib/one/running.file

#Wenn der VM-Name $vmName in der running.file gefunden wurde, dann #schreibe FOUND in die running.file, sonst NOTFound
if (grep $1 running.file >/dev/null)
	then
		echo "Found" > running.file
	else
		echo "NotFound" > running.file
fi

 
