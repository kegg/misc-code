param (
    [switch]$create = $false,
    [switch]$update = $false,
    [string]$file = "?"
)

Write-Host "args: $($args)"
Write-Host "args count: $($args.count)"
Write-Host "args: $($PsBoundParameters.Keys)"
Write-Host "args count: $($PsBoundParameters.Count)"