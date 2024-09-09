!/bin/sh
# find the distribution root and add java to the path.
echo "This file needs to be sourced like this: source path-init.sh"
echo ""

# Function to modify PATH based on the search results
get_path() {
    # Set IFS to handle paths with spaces correctly
    local IFS='
'
    
    # Find the resource (java, workspace)
    local path=$(find . -name $1 -type $2)

    # Count the number of elements (files)
    local count=$(echo "$path" | wc -l)
 
    if [ "$count" -ne 1 ]; then
        echo "Error: $count paths identified (not unique for $1)"
        # echo "No path added"
        return 1  # Exit with error code
    fi

    # Get the real path
    if [ "$2" = "f" ]; then
	local dir=$(dirname "$path")
    else
	local dir=$path
    fi

    # Get the absolute path of the directory
    local abspath=$(cd "$dir" && pwd)
    echo "$abspath"
}

# Call the function to get the java-binary directory
abspath=$(get_path java f)
PATH="$abspath:$PATH"
echo "Updated PATH: $PATH"

# set workspace variable for embedded directory
abspath=$(get_path workspace d)
WORKSP=$abspath
echo "WORKSP Variable set to: $WORKSP"
export WORKSP
