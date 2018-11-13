Update salary
Set sex=(
    Case
    When sex='f' Then 'm'
    Else 'f'
    End
)