#Skript um eine Virtuelle Maschine zu erzeugen. Erwartet 2 Argumente.
vmName=$1
templateName=$2

#Ersetze Name= NAME= name= mit name=$vmName in der template.File
sed -i "s/Name.*/Name="$1"/g" $2
sed -i "s/NAME.*/Name="$1"/g" $2
sed -i "s/name.*/Name="$1"/g" $2

#onevm create neue VM mit $template.name
# hier $template.name = u11.one
onevm create $2

#Zeige alle VMs and schreibe Ausgabe in die log.file
onevm list>/var/lib/one/log.file

#Schneide zeile heraus indem die $vm.name gefunden wurde schreibe die-se in die log.file (vm.names eindeutig sein)
#hier: ttylinux = $vm.name
awk '/'$1'/ {print>"/var/lib/one/log.file"}' /var/lib/one/log.file

#Lese ersten String der Datei und schreibe in die Variable  = $vmid
vmid=$(cut -d, -f1 /var/lib/one/log.file)

#Schreibe context-information über die ausgewählte VM in die log.file
onevm show $vmid > /var/lib/one/log.file 

#Schneide die ganze Zeile mit der IP aus und schreibe es in die #log.file
awk '/IP/ {print>"/var/lib/one/log.file"}' /var/lib/one/log.file

#Schneide nur den IP-Part und schreibe es in die log.file
awk -F'[=,]' '{print $2>"/var/lib/one/log.file"}' /var/lib/one/log.file  
 
