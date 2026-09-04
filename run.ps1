$env:Path = "$env:LOCALAPPDATA\Programs\kotlinc\bin;" + $env:Path
$files = (Get-ChildItem -Filter *.kt).Name

Write-Host "Compilando BookMaster UDB..." -ForegroundColor Cyan
kotlinc $files -include-runtime -d App.jar

if ($LASTEXITCODE -eq 0) {
    Write-Host "Iniciando programa...`n" -ForegroundColor Green
    java -jar App.jar
} else {
    Write-Host "`nOcurrió un error al compilar." -ForegroundColor Red
}
